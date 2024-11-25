import React from "react";
import { useEffect } from "react";
import { useSelector } from "react-redux";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const ToastMessage = () => {
  const { toastMessage } = useSelector((state) => state.ui);

  useEffect(() => {
    if (toastMessage) {
      const { message, status } = toastMessage;
      if (message !== "" && status !== "") {
        // 유효한 상태값인지 확인
        const validStatuses = ["success", "error", "info", "warn"];
        if (validStatuses.includes(status)) {
          toast[status](message, { theme: "colored" });
        } else {
          console.error(`Invalid toast status: ${status}`);
        }
      }
    }
  }, [toastMessage]);

  return (
    <ToastContainer
      position="top-center"
      autoClose={1500}
      hideProgressBar={false}
      newestOnTop={false}
      closeOnClick
      rtl={false}
      pauseOnFocusLoss
      draggable
      pauseOnHover
      theme="light"
    />
  );
};

export default ToastMessage;
