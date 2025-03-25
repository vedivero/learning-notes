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
		camera.position.z = 3;
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
		// 원뿔 형태의 Geometry
		// 첫 번째 인자 : 원의 반지름 크기(default:1),
		// 두 번째 인자 : 원뿔의 높이(default:1)
		// 세 번째 인자 : 둘레 방향에 대한 분할 개수(default:8)
		// 네 번째 인자 : 높이 방향에 대한 분할 개수(default:1)
		// 다섯 번째 인자 : 원뿔 밑면 개방 여부(default:false)
		// 여섯 번째 인자 : 원뿔의 시작 각도(default:0)
		// 일곱 번째 인자 : 원뿔의 연장 각도(default:2π)
		const geometry = new THREE.ConeGeometry(1, 5, 10, 10, true, 0, Math.PI);

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
