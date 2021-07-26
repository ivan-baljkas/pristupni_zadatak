import React, { Component } from 'react'

export const Pagination = (props) =>{

    return(
        <div>
            <button type="button" disabled = {currentPage === 1}>Previous</button>
             <span>  Current page:  {currentPage} </span>
             <button type="button"disabled = {currentPage === pages}>Next</button>
        </div>
    );
};