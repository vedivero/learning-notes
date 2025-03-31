import { forwardRef } from 'react';

function CustomInput(props, ref) {
   return (
      <div>
         <span>{props.label}</span>
         <input ref={ref} />
      </div>
   );
}

export default forwardRef(CustomInput);
