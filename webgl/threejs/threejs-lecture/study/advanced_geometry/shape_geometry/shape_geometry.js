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
		// Shape 모양 정의 샘플(x,y 좌표 사용)
		// shape.moveTo(1, 1); // 우측 상단
		// shape.lineTo(1, -1); // 우측 하단까지 선을 이음
		// shape.lineTo(-1, -1); // 좌측 하단까지 선을 이음
		// shape.lineTo(-1, 1); // 좌측 상단까지 선을 이음
		// shape.closePath(); // 도형을 닫는 메서드
		// 하트 모양
		const shape = new THREE.Shape();
		const x = -2.5,
			y = -5;
		shape.moveTo(x + 2.5, y + 2.5);
		shape.bezierCurveTo(x + 2.5, y + 2.5, x + 2, y, x, y);
		shape.bezierCurveTo(x - 3, y, x - 3, y + 3.5, x - 3, y + 3.5);
		shape.bezierCurveTo(x - 3, y + 5.5, x - 1.5, y + 7.7, x + 2.5, y + 9.5);
		shape.bezierCurveTo(x + 6, y + 7.7, x + 8, y + 4.5, x + 8, y + 3.5);
		shape.bezierCurveTo(x + 8, y + 3.5, x + 8, y, x + 5, y);
		shape.bezierCurveTo(x + 3.5, y, x + 2.5, y + 2.5, x + 2.5, y + 2.5);

		const geometry = new THREE.ShapeGeometry(shape);

		const fillMaterial = new THREE.MeshPhongMaterial({ color: 0x515151 });
		const cube = new THREE.Mesh(geometry, fillMaterial);

		const lineMaterial = new THREE.LineBasicMaterial({ color: 0xffff00 }); // 노란색 선 정의
		const line = new THREE.LineSegments( // Line 타입의 Object 생성
			new THREE.WireframeGeometry(geometry), // WireframeGeometry은 Wire형태로 Geometry를 구현하기 위해 사용
			lineMaterial
		);

		const group = new THREE.Group(); // Mesh Object와 Line Object를 하나의 Object로 다루기 위해 Group으로 묶음
		group.add(cube);
		group.add(line);

		this._scene.add(group); // Group객체를 Scene객체의 구성요소로 추가
		this._cube = group; // 또 다른 메서드에서 참조되어 사용할 수 있도록 필드 정의
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
