import React, { Component } from 'react'

export const SearchForm = (props) =>{

    return(
        <div>
            <form>
            <div>
                
                <label htmlFor="query">Query </label>
                <input type="text" id="query"/>
            </div>
            <div>
                <button type="button" onClick={props.handleSearch()}>Search</button>
                <p class="result">{props.children}</p>
            </div>   

            </form>   
            
        </div>
    );
};
