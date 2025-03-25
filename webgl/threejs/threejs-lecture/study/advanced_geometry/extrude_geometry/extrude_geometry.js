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
		camera.position.x = -15;
		camera.position.z = 15;
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

	// extrude_geometry : 평면 Shape에 깊이 값을 부여하고 Mesh의 윗 면과 밑 면을 비스듬하게 처리해주는 geometry = 베벨링
	_setupModel() {
		const x = -2.5,
			y = -5;
		const shape = new THREE.Shape();
		shape.moveTo(x + 2.5, y + 2.5);
		shape.bezierCurveTo(x + 2.5, y + 2.5, x + 2, y, x, y);
		shape.bezierCurveTo(x - 3, y, x - 3, y + 3.5, x - 3, y + 3.5);
		shape.bezierCurveTo(x - 3, y + 5.5, x - 1.5, y + 7.7, x + 2.5, y + 9.5);
		shape.bezierCurveTo(x + 6, y + 7.7, x + 8, y + 4.5, x + 8, y + 3.5);
		shape.bezierCurveTo(x + 8, y + 3.5, x + 8, y, x + 5, y);
		shape.bezierCurveTo(x + 3.5, y, x + 2.5, y + 2.5, x + 2.5, y + 2.5);

		// extrude_geometry 생성하기 위한 설정 값
		const settings = {
			steps: 4, // 깊이 방향으로의 분할 수(default:1)
			depth: 2, // 깊이 값(default:100)
			bevelEnabled: true, // 베벨링 처리 여부(default:true)
			bevelThickness: 0.4, // 베벨링 두께 값(default:6)
			bevelSize: 1, // Shape의 외곽선으로 부터 얼마나 멀리 베벨링 할 것인지(default:2)
			bevelSegments: 5, // 베벨링 단계 수(default:3)
		};

		const geometry = new THREE.ExtrudeGeometry(shape, settings);

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
