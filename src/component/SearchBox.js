// React와 useState 훅을 임포트
import React, { useState } from "react";
// FontAwesomeIcon을 임포트하여 아이콘 사용
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
// faSearch 아이콘을 임포트
import { faSearch } from "@fortawesome/free-solid-svg-icons";
// useSearchParams 훅을 react-router-dom에서 임포트
import { useSearchParams } from "react-router-dom";

// SearchBox 컴포넌트를 정의, searchQuery, setSearchQuery, placeholder, field를 props로 받음
const SearchBox = ({ searchQuery, setSearchQuery, placeholder, field }) => {

  // 현재 쿼리 파라미터를 가져옴
  const [query] = useSearchParams();
  // 키워드 상태를 관리하기 위해 useState 훅 사용, 초기값은 쿼리 파라미터에서 가져옴
  const [keyword, setKeyword] = useState(query.get(field) || "");

  // Enter 키를 눌렀을 때 호출되는 함수
  const onCheckEnter = (event) => {
    if (event.key === "Enter") {
      // Enter 키가 눌리면 검색 쿼리를 업데이트하고 페이지 번호를 1로 설정
      setSearchQuery({ ...searchQuery, page: 1, [field]: event.target.value });
    }
  };

  return (
    <div className="search-box">
      {/* 검색 아이콘을 표시 */}
      <FontAwesomeIcon icon={faSearch} />
      {/* 검색 입력 필드 */}
      <input
        type="text"
        placeholder={placeholder}
        onKeyPress={onCheckEnter}
        onChange={(event) => setKeyword(event.target.value)}
        value={keyword}
      />
    </div>
  );
};

// SearchBox 컴포넌트를 기본 내보내기로 내보냄
export default SearchBox;
