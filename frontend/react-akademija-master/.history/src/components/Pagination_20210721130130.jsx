import React, { Component } from 'react'

export const Pagination = (props) =>{

    return(
        <div>
            <button type="button" >Previous</button>
             <span>  Current page:   </span>
             <button type="button">Next</button>
        </div>
    );
};