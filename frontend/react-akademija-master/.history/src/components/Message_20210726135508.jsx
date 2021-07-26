import React from 'react'

export const Message = (props) =>{

    return(
        <div>
            {props.uvjetMessage? <h5>Uspješno naručeno!</h5>:<div></div>}
        </div>

    );

    }