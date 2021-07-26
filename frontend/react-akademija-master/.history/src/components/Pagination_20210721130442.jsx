import React, { Component } from 'react'

export const Pagination = (props) =>{

    return(
        <div>
            <button type="button" disabled = {props.currentPage === 1}>Previous</button>
             <span>  Current page:  {props.currentPage} </span>
             <button type="button"disabled = {props.currentPage === props.pages}>Next</button>
        </div>
    );
};