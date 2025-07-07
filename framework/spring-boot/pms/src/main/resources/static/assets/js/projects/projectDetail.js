

async function loadProjectDetail(projectId) {

    try {
        const response = await fetch(`/api/projects/${projectId}`);
        if(!response.od) throw new Error(`HTTP ${response.status}`);
        const data = await response.json();
        console.log(data);
    } catch (error) {
        console.error("프로젝트 상세 정보 조회 실패",error);
    }
    
}