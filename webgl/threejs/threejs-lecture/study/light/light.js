import * as THREE from "../../build/three.module.js";
import { OrbitControls } from "../../../examples/jsm/controls/OrbitControls.js";

class App {
	constructor() {
		const divContainer = document.getElementById("webgl-container");
		this._divContainer = divContainer;

		const renderer = new THREE.WebGLRenderer({ antialias: true });
		renderer.setPixelRatio(window.devicePixelRatio);
		divContainer.appendChild(renderer.domElement);
		this._renderer = renderer;

		const scene = new THREE.Scene();
		this._scene = scene;

		this._setupCamera();
		this._setupLight();
		this._setupModel();
		this._setupControls();

		window.onresize = this.resize.bind(this);
		this.resize();

		requestAnimationFrame(this.render.bind(this));
	}

	_setupControls() {
		new OrbitControls(this._camera, this._divContainer); // 카메라 객체와 마우스 이벤트를 받는 DOM 요소가 필요
	}

	_setupModel() {
		// ground
		const groundGeometry = new THREE.PlaneGeometry(10, 10);
		const groundMaterial = new THREE.MeshStandardMaterial({
			color: "#5dade2",
			roughness: 0.5,
			metalness: 0.5,
			side: THREE.DoubleSide,
		});

		const ground = new THREE.Mesh(groundGeometry, groundMaterial);
		ground.rotation.x = THREE.MathUtils.degToRad(-90);
		this._scene.add(ground);

		// bigSphere
		const bigSphereGeometry = new THREE.SphereGeometry(1.5, 64, 64, 0, Math.PI);
		const bigSphereMaterial = new THREE.MeshStandardMaterial({
			color: "#ffffff",
			roughness: 0.1,
			metalness: 0.2,
		});

		const bigSphere = new THREE.Mesh(bigSphereGeometry, bigSphereMaterial);
		bigSphere.rotation.x = THREE.MathUtils.degToRad(-90);
		this._scene.add(bigSphere);

		// torusPivot & torus
		const torusGeometry = new THREE.TorusGeometry(0.4, 0.1, 32, 32);
		const torusMaterial = new THREE.MeshStandardMaterial({
			color: "#9b59b6",
			roughness: 0.5,
			metalness: 0.9,
		});

		for (let i = 0; i < 8; i++) {
			const torusPivot = new THREE.Object3D();
			const torus = new THREE.Mesh(torusGeometry, torusMaterial);
			torusPivot.rotation.y = THREE.MathUtils.degToRad(45 * i);
			torus.position.set(3, 0.5, 0);
			torusPivot.add(torus);
			this._scene.add(torusPivot);
		}

		// smallSpherePivot & smallSphere
		const smallSphereGeometry = new THREE.SphereGeometry(0.3, 32, 32);
		const smallSphereMaterial = new THREE.MeshStandardMaterial({
			color: "#fbc7a7",
			roughtness: 0.2,
			metalness: 0.5,
		});
		const smallSpherePivot = new THREE.Object3D();
		const smallSphere = new THREE.Mesh(
			smallSphereGeometry,
			smallSphereMaterial
		);
		smallSpherePivot.add(smallSphere);
		smallSpherePivot.name = "smallSpherePivot";
		smallSphere.position.set(3, 0.5, 0);
		this._scene.add(smallSpherePivot);
	}

	_setupCamera() {
		const width = this._divContainer.clientWidth;
		const height = this._divContainer.clientHeight;
		const camera = new THREE.PerspectiveCamera(75, width / height, 0.1, 100);
		camera.position.set(7, 7, 0);
		camera.lookAt(0, 0, 0);
		this._camera = camera;
	}

	_setupLight() {
		// 1
		// const light = new THREE.AmbientLight(0xffffff, 10);
		// this._scene.add(light);
		// this._light = light;

		// 2
		// const light = new THREE.DirectionalLight(0xffffff, 3);
		// light.position.set(0, 5, 0);
		// light.target.position.set(0, 0, 0);
		// this._scene.add(light.target);

		// const helper = new THREE.DirectionalLightHelper(light);
		// this._scene.add(helper);
		// this._lightHelper = helper;

		// 3
		// const light = new THREE.PointLight(0xffffff, 115);
		// light.position.set(0, 5, 0);

		// const helper = new THREE.PointLightHelper(light);
		// this._scene.add(helper);
		const light = new THREE.SpotLight(0xffffff, 5);
		light.position.set(0, 5, 0);
		light.target.position.set(0, 0, 0);
		light.angle = THREE.MathUtils.degToRad(40);
		light.penumbra = 0;
		this._scene.add(light.target);

		const helper = new THREE.SpotLightHelper(light);
		this._scene.add(helper);
		this._lightHelper = helper;

		this._scene.add(light);
		this._light = light;
	}

	update(time) {
		time *= 0.001;
		const smallSpherePivot = this._scene.getObjectByName("smallSpherePivot");
		if (smallSpherePivot) {
			smallSpherePivot.rotation.y = THREE.MathUtils.degToRad(time * 50);

			// if (this._light) {
			// 	const smallSphere = smallSpherePivot.children[0];
			// 	smallSphere.getWorldPosition(this._light.position);

			// 	if (this._lightHelper) this._lightHelper.update();
			// }
		}
	}

	render(time) {
		this._renderer.render(this._scene, this._camera);
		this.update(time);
		requestAnimationFrame(this.render.bind(this));
	}

	resize() {
		const width = this._divContainer.clientWidth;
		const height = this._divContainer.clientHeight;

		this._camera.aspect = width / height;
		this._camera.updateProjectionMatrix();

		this._renderer.setSize(width, height);
	}
}
window.onload = function () {
	new App();
};
