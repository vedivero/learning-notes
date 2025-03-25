import * as THREE from "../../../build/three.module.js";
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

	_setupCamera() {
		const width = this._divContainer.clientWidth;
		const height = this._divContainer.clientHeight;
		const camera = new THREE.PerspectiveCamera(75, width / height, 0.1, 100);
		camera.position.z = 14;
		this._camera = camera;
	}

	_setupLight() {
		const color = 0xffffff;
		const intensity = 20;
		const light = new THREE.DirectionalLight(color, intensity);
		light.position.set(-1, 2, 4);
		this._scene.add(light);
	}

	_setupControls() {
		new OrbitControls(this._camera, this._divContainer); // 카메라 객체와 마우스 이벤트를 받는 DOM 요소가 필요
	}

	_setupModel() {
		// 곡선을 따라 원통이 이어지는 형태
		// Tube를 이해하기 위해 곡선을 정의하는 Curve Class를 파악해야 함

		class CustomSinCurve extends THREE.Curve {
			constructor(scale) {
				super();
				this.scale = scale;
			}
			// t매개 변수의 방정식으로 정의
			getPoint(t) {
				// 0과 1사이의 t값에 대한 Curve의 구성 좌표를 계산
				const tx = t * 3 - 1.5;
				const ty = Math.sin(2 * Math.PI * t);
				const tz = 0;
				return new THREE.Vector3(tx, ty, tz).multiplyScalar(this.scale);
			}
		}
		const path = new CustomSinCurve(4);

		const geometry = new THREE.BufferGeometry();
		const points = path.getPoints(100); // 커브를 구성하는 좌표의 개수(default:5)
		geometry.setFromPoints(points);

		const material = new THREE.LineBasicMaterial({ color: 0xffff00 });
		const line = new THREE.Line(geometry, material);

		this._scene.add(line);
	}

	resize() {
		const width = this._divContainer.clientWidth;
		const height = this._divContainer.clientHeight;

		this._camera.aspect = width / height;
		this._camera.updateProjectionMatrix();

		this._renderer.setSize(width, height);
	}

	render(time) {
		this._renderer.render(this._scene, this._camera);
		requestAnimationFrame(this.render.bind(this));
	}
}
window.onload = function () {
	new App();
};
