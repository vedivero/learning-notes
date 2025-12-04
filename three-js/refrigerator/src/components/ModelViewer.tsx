import { Suspense, useEffect } from 'react';
import { Canvas } from '@react-three/fiber';
import { OrbitControls, Environment, Html, useGLTF, Bounds } from '@react-three/drei';
import type { Object3D } from 'three';

// Draco 디코더를 구글 CDN에서 불러와 브라우저에서 압축 GLB를 해제하도록 지정.
useGLTF.setDecoderPath('https://www.gstatic.com/draco/versioned/decoders/1.5.6/');

type Props = { url?: string };

// FridgeModel: 냉장고 GLB를 로드하고, 노드 그래프를 확인할 수 있는 콘솔 도구를 등록.
// 매개변수: url(옵션) - GLB 파일 경로, 기본값은 번들된 냉장고 모델.
// 효과: 렌더링 가능한 Three.js primitive를 반환하고 디버깅용 window.glbTools를 노출.
function FridgeModel({ url = '/models/M-Next3.glb' }: Props) {
  const { scene } = useGLTF(url);

  useEffect(() => {
    // buildTree: Three.js 객체 계층을 잘라서 트리 형태의 스냅샷 생성.
    // 매개변수: obj=대상 노드; maxDepth=탐색 깊이 제한; maxChildren=노드당 자식 최대 개수; depth=내부 추적용.
    // 기대 효과: 구조 요약 객체를 반환해 로그/디버깅 UI에서 계층을 간단히 파악 가능.
    const buildTree = (
      obj: Object3D,
      maxDepth = 3,
      maxChildren = 50,
      depth = 0
    ): any => ({
      name: obj.name || '(no-name)',
      type: obj.type,
      children:
        depth >= maxDepth
          ? [`(+${obj.children.length} more children)`]
          : obj.children.slice(0, maxChildren).map(child => buildTree(child, maxDepth, maxChildren, depth + 1)),
    });

    // collectPaths: 전체 씬 그래프를 읽기 쉬운 경로 문자열 목록으로 평탄화.
    // 매개변수: obj=시작 노드; parents=상위 노드 이름 배열로 경로를 구성.
    // 기대 효과: {path, type, children} 배열을 만들어 노드를 빠르게 검색/열람 가능.
    const collectPaths = (
      obj: Object3D,
      parents: string[] = []
    ): { path: string; type: string; children: number }[] => {
      const current = [...parents, obj.name || '(no-name)'];
      const here = { path: current.join('/'), type: obj.type, children: obj.children.length };
      return obj.children.reduce(
        (acc, child) => acc.concat(collectPaths(child, current)),
        [here]
      );
    };

    const allPaths = collectPaths(scene);

    // glbTools: 추가 UI 없이 콘솔에서 GLB 구조를 탐색하는 헬퍼.
    // - allPaths: 모든 노드의 평탄화 리스트.
    // - findPaths(needle, limit): 경로에 포함된 문자열로 노드 검색, limit는 결과 개수 제한.
    // - subtree(name, maxDepth, maxChildren): 지정 노드부터 잘린 트리 추출.
    // - tree(maxDepth, maxChildren): 전체 씬을 잘라서 트리로 표시.
    // 기대 효과: GLB 구조를 수정/확인할 때 빠르게 노드 정보를 파악.
    (window as any).glbTools = {
      allPaths,
      findPaths: (needle: string, limit = 50) =>
        allPaths.filter(p => p.path.includes(needle)).slice(0, limit),
      subtree: (name: string, maxDepth = 3, maxChildren = 50) => {
        const node = scene.getObjectByName(name);
        return node ? buildTree(node, maxDepth, maxChildren) : null;
      },
      tree: (maxDepth = 3, maxChildren = 50) => buildTree(scene, maxDepth, maxChildren),
    };

    console.log('GLB helpers ready: glbTools.findPaths("needle"), glbTools.subtree("NodeName"), glbTools.tree()');
  }, [scene]);

  // GLB 씬을 Three.js primitive로 반환하여 R3F 캔버스에 배치 가능하게 렌더.
  return <primitive object={scene} />;
}

// 뷰어 렌더 전에 냉장고 GLB를 캐시해 초기 렌더 지연을 줄임.
useGLTF.preload('/models/M-Next3.glb');

// ModelViewer: R3F 캔버스에 조명/환경/컨트롤/모델을 조합한 인터랙티브 뷰어.
// 매개변수: 없음.
// 기대 효과: 사용자가 냉장고 모델을 회전하며 확인할 수 있는 3D 뷰어를 제공.
export default function ModelViewer() {
  return (
    <Canvas camera={{ position: [2.5, 1.8, 2.5], fov: 50 }} style={{ width: '100%', height: '100%' }}>
      {/* Scene background and base lighting */}
      <color attach="background" args={['#0f0f0f']} />
      <ambientLight intensity={0.4} />
      <directionalLight position={[3, 5, 3]} intensity={1.2} />

      {/* GLB loading UI, model framing, and studio environment */}
      <Suspense fallback={<Html center style={{ color: '#eaeaea' }}>Loading GLB...</Html>}>
        <Bounds fit clip observe margin={1.2}>
          <FridgeModel />
        </Bounds>
        <Environment preset="studio" />
      </Suspense>

      {/* Camera orbit controls */}
      <OrbitControls makeDefault enableDamping dampingFactor={0.08} />
    </Canvas>
  );
}
