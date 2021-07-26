import React from 'react'

export const NarudzbaForm = (props) =>{

    return(
        <div>
            <form  onClick={props.handleSearch}>
            <div>
                
                <label htmlFor="query">Kod za popust</label>
                <input type="text" id="brand" name="brand" onChange={props.handleQueryChange}/>
                
            </div>
            <div>
                
                <label htmlFor="query">Broj kartice</label>
                <input type="text" id="brand" name="brand" onChange={props.handleQueryChange}/>
                
            </div>

            <div>
                
                <label htmlFor="query">Email</label>
                <input type="email" id="brand" name="brand" onChange={props.handleQueryChange}/>
                
            </div>

            <div>
                
                <label htmlFor="query">Broj mobitela</label>
                <input type="text" id="brand" name="brand" onChange={props.handleQueryChange}/>
                
            </div>

            <div>
                
                <label htmlFor="query">Adresa dostave</label>
                <input type="text" id="brand" name="brand" onChange={props.handleQueryChange}/>
                
            </div>

            <div>
                
                <label htmlFor="query">Napomena</label>
                <input type="text" id="brand" name="brand" onChange={props.handleQueryChange}/>
                
            </div>
            <div>
                
                <label htmlFor="query">Brand</label>
                <input type="text" id="brand" name="brand" onChange={props.handleQueryChange}/>
                
            </div>
            <div>
            <   label htmlFor="query">Naziv</label>
                <input type="text" id="naziv" name="naziv" onChange={props.handleQueryChange}/>
            </div>
            <div>
                <label htmlFor="query">Cijena</label>
                <input type="number" id="cijena" name="cijena" onChange={props.handleQueryChange}/> 
                
            </div>  
            <div>
                <button type="submit">Filtriraj</button>
            </div> 

            </form>   
            
        </div>
    );
};