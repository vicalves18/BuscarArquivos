import React from 'react';
import {api} from '../service/api';
import  'bootstrap/dist/css/bootstrap.min.css' ;
 

const Pesquisa = ({id, pesquisa}) => {
    const handleSubmit = async (event) => {
        event.preventDefault()
        const value = {
            nome: document.getElementById('nome').value,
            data: document.getElementById('data').value,
            tipo: document.getElementById('tipo').value,
            
        }
        console.log(value);
        handlePost(value);
            

    }

    

    const handlePost = () => {
        let _data = {
            nome: "Victoria",
            data: "27/04/2022", 
            tipo: "retorno"
          }
        fetch('/pesquisa', {
        method: "POST",
        body: JSON.stringify(_data),
        headers: {"Content-type": "application/json; charset=UTF-8"}
    })
    
    }
   
    return(
        <div className="justify-content-center">
            <div className='row mt-5 pt-3 m-4 d-flex '  onSubmit={(event) => handleSubmit(event)}>
                <div className='col-2'>
                   <b>Nome:</b> 
                </div>
                <hr size="5"></hr>
                <div className='row mt-2'>
                    <div className='col-4'>
                        <input id='nome' className='form-control name-pull-image' type='text'></input>
                    </div>
                </div>
                <div className='col-2 pt-3'>
                   <b>Tipo:</b> 
                </div>
                <hr size="5"></hr>
                <div className='row mt-2'>
                    <div className='col-4'>
                        <select id="tipo" name="select" className="form-select" aria-label="Default select example">Escolha o tipo 
                            <option value="TODOS">TODOS</option>
                            <option value="REMESSA">REMESSA</option>
                            <option value="RETORNO">RETORNO</option>
                        </select>
                    </div>
                </div>
                <div className='col-2 pt-3'>
                   <b> Data:</b>
                </div>
                <hr size="5"></hr>
                <div className='row mt-2'>
                    <div className='col-4'>
                        <input id='data' className='form-control name-pull-image' type='date'></input>
                    </div>
                </div>
                
                <div className='row mt-2'>
                    <div className='col-1'>
                        <button className='btn btn-primary' type="submit" onClick={handlePost}> Pesquisar</button>
                    </div>
                    <div className='col-1'>
                        <button className="btn btn-primary" type="reset" value="Reset">Limpar</button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Pesquisa;

  