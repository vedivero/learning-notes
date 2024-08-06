import { useParams } from 'react-router-dom'; //URL 파라미터를 꺼내올 수 있는 커스텀 훅

const Edit = () => {
  const param = useParams();
  return <div>{param.id}번 일기입니다.</div>;
};

export default Edit;
