document.addEventListener("DOMContentLoaded",function(){
    getProjectList();
})

const getProjectList = async()=>{
    
    try {
        const response = await fetch(`/api/projects`);
        if(!response)  throw new Error(`HTTP ${response.status}`);
        const proejcts = await response.json();
        renderProjectList(proejcts);
    } catch (error) {
        console.error("프로젝트 목록 조회 실패",error);
    }

}

const renderProjectList=(projects)=>{
     const tbody = document.querySelector("#projectTable tbody");
  tbody.innerHTML = "";

  projects.forEach(project => {
    const tr = document.createElement("tr");

    // ID
    const idTd = document.createElement("td");
    idTd.textContent = project.projectId;

    // 프로젝트명
    const nameTd = document.createElement("td");
    nameTd.textContent = project.projectName;

    // 상태
    const statusTd = document.createElement("td");
    statusTd.textContent = project.status;

    // 시작일
    const startDateTd = document.createElement("td");
    startDateTd.textContent = project.startDate;

    // 종료일
    const endDateTd = document.createElement("td");
    endDateTd.textContent = project.endDate;

    // <tr>에 <td> 붙이기
    tr.appendChild(idTd);
    tr.appendChild(nameTd);
    tr.appendChild(statusTd);
    tr.appendChild(startDateTd);
    tr.appendChild(endDateTd);

    // tbody에 <tr> 붙이기
    tbody.appendChild(tr);
  });
};