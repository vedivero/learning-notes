import { forwardRef, useImperativeHandle, useRef, useState } from 'react';

function CustomInput2(props, ref) {
   const [value, setValue] = useState('');
   const inputRef = useRef();

   useImperativeHandle(
      ref,
      () => {
         return {
            getValue: () => {
               {
                  return value;
               }
            },
            focus: () => {
               inputRef.current.focus();
            },
         };
      },
      [value],
   );

   return (
      <div>
         <span>{props.label}</span>
         <input
            value={value}
            ref={inputRef}
            onChange={(e) => {
               setValue(e.target.value);
            }}
         />
      </div>
   );
}

export default forwardRef(CustomInput2);
