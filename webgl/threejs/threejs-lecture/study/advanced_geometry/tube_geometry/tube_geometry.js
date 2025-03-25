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
		const path = new CustomSinCurve(4); // tube가 이어지는 형태를 결정하기 위한 Curve 객체를 path라는 이름으로 생성

		// 첫 번째 인자 : 튜브가 따라갈 경로를 정의한 Curve 객체 (예: S자 곡선, 나선 등)
		// 두 번째 인자 : 튜브 진행 방향에 대한 분할 수(default:64)
		// 두 번째 인자 : 튜브 원통에 대한 반지름 크기(default:1)
		// 네 번째 인자 : 튜브 원통에 대한 분할 수(default:8)
		// 다섯 번째 인자 : 튜브 원통의 시작 단과 끝단 개방 여부(default:false)
		const geometry = new THREE.TubeGeometry(path, 128, 0.5, 16, true); // path를 Tube Geometry 생성자에 전달

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
