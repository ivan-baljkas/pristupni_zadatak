import React from 'react'

export const NarudzbaForm = (props) =>{

    return(
        <div>
            <form className="container" onClick={props.handleSearch}>

            <div>
                
                <label htmlFor="query">Ukupna cijena</label>
                <input type="number" id="brand" name="brand" disabled={true} value={props.ukupnaCijena}/>
                
            </div>
            <div>
                
                <label htmlFor="query">Kod za popust</label>
                <input type="text" id="brand" name="brand" onChange={props.handleQueryChange}/>
                
            </div>
            <div>
                <label for="placanje">Odaberi način plaćanja:</label>
                <select name="placanje" id="placanje">
                    {props.naciniPlacanja.map(np=>
                        <option value="saab">np.naziv</option>
                    )        
                    }
                </select>
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
                <button type="submit">Naruči</button>
            </div> 

            </form>   
            
        </div>
    );
};