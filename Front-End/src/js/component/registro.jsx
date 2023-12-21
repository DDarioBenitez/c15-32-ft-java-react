import React, { useState } from "react";
import {request} from "../services/AxiosService";
import { useNavigate } from "react-router";

// pagina compra y envio lleva a mercadopago request. llegaria el id y destalles de compra y con eso mostrar en el perfil
//registro, compra checkout, endpoint nuevo sale, borrar, comentario mostrarlo añadirlo borrarlo, editarlo, pdf para descargar boleta, ver todos productos, ver por id para ver un producto con sus detalles, registro, admin, dario readme con los requisitos de cada endpoint, crear un dashboard para editar borrar basico una tabla
//elegir horario con mateo

export default function Registro()
{
    const navigate = useNavigate();

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [nombre, setNombre] = useState("");
    const [apellido, setApellido] = useState("");
    const [telefono, setTelefono] = useState("");
    const [formError, setFormError] = useState("");


    const onFormSubmit = e =>
    {
        e.preventDefault();
        const form = {email, password, nombre, apellido, telefono};
        request("POST", "/register/cliente", form).then(() =>
        {
            navigate("/");

            // Hacer login automaticamente
            request("POST", `/login?email=${email}&password=${password}`, {});
        })
        .catch(error =>
        {
            setFormError(error.response.data);
        });
        console.log({form});
    };

    return (
        <main className="  py-5">
            <hr />
            
            <div className="m-auto p-4  " 
            // shadow style={{minWidth: "40rem"}}
            >
                <div className="mb-4 text-center">
                <h5 className=" fw-normal text-uppercase ">REGISTRATE!</h5>
                <small className=" fw-light">Recibe ofertas y descuentos exclusivos por ser parte de nuestra comunidad</small>
            </div>
                <p className="small text-danger">{formError}</p>

                <form className="form-logIn form-register" onSubmit={onFormSubmit} noValidate>
                    <div className="mb-3">
                        {/* <label className="form-label" htmlFor="email">Correo electrónico</label> */}
                        <input className="form-control text-uppercase" type="text" id="email" name="email" onChange={e => setEmail(e.target.value)} placeholder="INGRESA TU CORREO: ejemplo@email.com" required/>
                    </div>

                    <div className="mb-3">
                        {/* <label className="form-label" htmlFor="password">Contraseña</label> */}
                        <input className="form-control " type="text" id="password" name="password" placeholder="CREA TU CONTRASEÑA" onChange={e => setPassword(e.target.value)} required/>
                    </div>

                    <div className="mb-3">
                        {/* <label className="form-label" htmlFor="password">Contraseña</label> */}
                        <input className="form-control text-uppercase" type="text" id="nombre" name="nombre" placeholder="NOMBRE" onChange={e => setNombre(e.target.value)} required/>
                    </div>

                    <div className="mb-3">
                        {/* <label className="form-label" htmlFor="password">Contraseña</label> */}
                        <input className="form-control text-uppercase" type="text" id="apellido" name="apellido" placeholder="APELLIDO" onChange={e => setApellido(e.target.value)} required/>
                    </div>

                    <div className="mb-3">
                        {/* <label className="form-label" htmlFor="password">Contraseña</label> */}
                        <input className="form-control text-uppercase" type="tel" id="telefono" name="telefono" placeholder="TELEFONO" onChange={e => setTelefono(e.target.value)} required/>
                    </div>

                    <button type="submit" className="btn btn-dark  text-uppercase w-100">enviar</button>
                </form>
            </div>
        </main>
    )
}