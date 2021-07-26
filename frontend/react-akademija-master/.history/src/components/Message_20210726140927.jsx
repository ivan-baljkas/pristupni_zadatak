import React from 'react'

export const Message = (props) =>{

    return(
        <div>
            {props.uvjetMessage===true? <h5>Uspješno naručeno!</h5>:<div></div>}
        </div>

    );

    }