//현재 브라우저에 명시한 URL파라미터 값을 가져오는 커스텀 훅
import { useParams } from 'react-router-dom';

const Diary = () => {
  const params = useParams();
  console.log(params);
  return <div>{params.id}번 Diary</div>;
};

export default Diary;
