import React, { Component } from 'react'

export const SearchForm = (props) =>{

    return(
        <div>
            <form  onClick={props.handleSearch('Timebomb')}>
            <div>
                
                <label htmlFor="query">Query </label>
                <input type="text" id="query"/>
            </div>
            <div>
                <button type="submit">Search</button>
                <p class="result">{props.children}</p>
            </div>   

            </form>   
            
        </div>
    );
};
