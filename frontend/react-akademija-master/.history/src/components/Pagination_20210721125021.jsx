import React, { Component } from 'react'

export const Pagination = (props) =>{

    return(
        <div>
             <button type="button">Previous</button>
             <span>  Current page: 1  </span>
             <button type="button">Next</button>
        </div>
    );
};