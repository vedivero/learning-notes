import * as THREE from "../../../build/three.module.js";
import { OrbitControls } from "../../../examples/jsm/controls/OrbitControls.js";

class App {
	constructor() {
		const divContainer = document.getElementById("webgl-container");
		this._divContainer = divContainer; // 다른 메서드에서 참조할 수 있도록 객체의 필드로 정의

		const renderer = new THREE.WebGLRenderer({ antialias: true }); // 렌더러 생성 - antialias 활성 : 오브젝트 경계선 부드럽게 표현
		renderer.setPixelRatio(window.devicePixelRatio); // 모니터 배율
		divContainer.appendChild(renderer.domElement); // renderer에 생성된 domElement를 id가 webgl-container인 컨테이너의 자식으로 설정
		this._renderer = renderer; // 참조할 수 있도록 필드로 정의

		const scene = new THREE.Scene(); // Scene 클래스로 간단히 Scene 객체 생성
		this._scene = scene; // Scene 객체를 필드화, App클래스의 다른 메서드에서도 참조 가능

		this._setupCamera(); // 카메라 객체 메서드 호출
		this._setupLight(); // 라이트 설정 메서드 호출
		this._setupModel(); // 3차원 모델 설정 메서드 호출
		this._setupControls();

		// 창 크기 변경 이벤트, 랜더러나 카메라는 창 크기에 맞게 속성을 재 설정해야 함
		// resize 메서드 안에서 this가 가리키는 객체가 이벤트 객체가 아닌, App객체가 되도록 하기 위함
		window.onresize = this.resize.bind(this);
		this.resize(); // 창 크기 변경 이벤트인 reisze와 상관없이, 생성자에서 무조건 호출해서 렌더러와 카메라 속성을 창 크기에 맞게 설정

		// requestAnimationFrame라는 API에 넘겨줘서 호출
		// 3차원 그래픽 장면을 만들어 주는 메서드
		requestAnimationFrame(this.render.bind(this));
	}

	_setupControls() {
		new OrbitControls(this._camera, this._divContainer); // 카메라 객체와 마우스 이벤트를 받는 DOM 요소가 필요
	}

	_setupModel() {
		// 이 재질은 mesh를 렌더링되는 픽셀 단위로 광원의 영향을 계산하는 재질
		const material = new THREE.MeshStandardMaterial({
			color: 0xff0000, // 재질의 색상
			emissive: 0x00000, // 다른 광원에 영향을 받지 않는 재질 자체에서 방출하는 색상 값, 기본값:black, 방출하지 않음
			roughness: 0.25, // 거칠기 (0: 거칠기가 없는 상태, 거울과 같은 상태)
			metalness: 0.1, // 금속성 (0: 돌 처럼 금속성이 없는 상태 / 1: 금속상태)
			wireframe: false, // mesh를 선 형태로 렌더링할 것인지 여부
			flatShading: false, //
		});

		const box = new THREE.Mesh(new THREE.BoxGeometry(1, 1, 1), material);
		box.position.set(-1, 0, 0);
		this._scene.add(box);

		const sphere = new THREE.Mesh(
			new THREE.SphereGeometry(0.7, 32, 32),
			material
		);
		sphere.position.set(1, 0, 0);
		this._scene.add(sphere);
	}

	// 창 크기가 변경될 때 발생되는 이벤트
	resize() {
		const width = this._divContainer.clientWidth;
		const height = this._divContainer.clientHeight;

		this._camera.aspect = width / height; // divContainer의 사이즈로 카메라의 속성 값 설정
		this._camera.updateProjectionMatrix();

		this._renderer.setSize(width, height); // renderer의 크기를 설정
	}

	_setupCamera() {
		// THREE.JS가 3차원 그래픽을 출력할 영역의 가로x세로 크기
		const width = this._divContainer.clientWidth;
		const height = this._divContainer.clientHeight;
		const camera = new THREE.PerspectiveCamera(75, width / height, 0.1, 100); // 카메라 객체 생성
		camera.position.z = 3; // 카메라 위치 설정
		this._camera = camera; // 생성한 카메라 객체를 또 다른 메서드에서 사용할 수 있도록 필드화
	}

	_setupLight() {
		const color = 0xffffff; // 색상
		const intensity = 10; // 광원의 세기
		const light = new THREE.DirectionalLight(color, intensity); // 광원 생성
		light.position.set(-1, 2, 4); // 광원의 위치
		this._scene.add(light); // 광원 필드화
	}

	update(time) {
		time *= 0.001; // 전달 받은 ms단위를 s 단위로 변경
	}

	// time: render함수가 실행된 이후에 경과된 시간 값(단위 ms)
	// time인자를 통해 장면의 애니메이션에 이용
	render(time) {
		this._renderer.render(this._scene, this._camera); // scene을 camera의 시점을 이용해서 렌더링
		this.update(time); // update 메서드 안에서 속성 값 변경 - 애니메이션 효과 발생
		requestAnimationFrame(this.render.bind(this)); // 이 코드를 통해 렌더 메서드가 무한으로 반복해서 호출
	}
}
window.onload = function () {
	new App();
};
