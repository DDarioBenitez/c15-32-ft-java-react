import React, { useState } from "react";
import {request} from "../services/AxiosService";
import {Link, useNavigate} from "react-router-dom";


export default function Login()
{
    const navigate = useNavigate();

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [formError, setFormError] = useState("");


    const onFormSubmit = e =>
    {
        e.preventDefault();

        request("POST", `/login?email=${email}&password=${password}`, {}).then(() => {
            navigate("/");
        })
        .catch(() => {
            setFormError("Correo electrónico o contraseña incorrecta");
        });
    };


    return (
        <main className="container py-5">
            <div className="mb-4 text-center">
                <h2 className="display-6 fw-semibold text-uppercase">Iniciar sesión</h2>
            </div>
            
            <div className="m-auto p-4 bg-white border rounded-3 shadow" style={{maxWidth: "40rem"}}>
                <p className="small text-danger">{formError}</p>

                <form onSubmit={onFormSubmit} noValidate>
                    <div className="mb-3">
                        <label className="form-label" htmlFor="email">Correo electrónico</label>
                        <input className="form-control" type="text" id="email" name="email" onChange={e => setEmail(e.target.value)} placeholder="ejemplo@email.com" required/>
                    </div>

                    <div className="mb-3">
                        <label className="form-label" htmlFor="password">Contraseña</label>
                        <input className="form-control" type="password" id="password" name="password" onChange={e => setPassword(e.target.value)} required/>
                    </div>

                    <div>
                        <button type="submit" className="btn btn-primary fw-bold w-100">Iniciar sesión</button>

                        <hr className="my-4"></hr>
                        
                        <div className="d-flex flex-wrap align-items-center justify-content-center gap-2">
                            <p className="mb-0">¿No tienes una cuenta?</p>
                            <Link to={"/registro"} className="btn btn-success fw-bold">Regístrate</Link>
                        </div>
                    </div>
                </form>
            </div>
        </main>
    )
}
