import React, { Component } from 'react'

export const Pagination = (props) =>{

    return(
        <div className="pagination">
            <button type="button" disabled = {props.currentPage === 1} onClick={props.handlePrevious}>Previous</button>
             <span>  Current page:  {props.currentPage} </span>
             <button type="button"disabled = {props.currentPage === props.pages} onClick={props.handleNext}>Next</button>
        </div>
    );
};