package com.mibanco.clientecdtdigital.es.controller;

import com.mibanco.clientecdtdigital.es.gen.contract.V1ClientecdtdigitalApi;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import com.mibanco.clientecdtdigital.es.services.impl.ClienteCDTDigitalImpl;
import com.mibanco.clientecdtdigital.es.utils.exception.ApplicationException;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClienteCDTDigidalController implements V1ClientecdtdigitalApi {
    private  static  final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigidalController.class);

    @Inject
    ClienteCDTDigitalImpl clienteCDTDigitalImpl;

    @Override
    public Response buscarClienteCDTDigital(Integer idCliente) {
        LOG.info("Inicia el metodo buscarClienteCDTDigital_1 Controller");
        ClienteCDTDigitalType clienteCDTDigitalTypeResponse ;
        try{
            clienteCDTDigitalTypeResponse = clienteCDTDigitalImpl.buscarClienteCDTDigital(idCliente);
        }catch(ApplicationException e){
            LOG.error("Se presento un error en el metodo buscarClienteCDTDigital_1 controller"+ e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        LOG.info("Finaliza el metodo buscarClienteCDTDigital_1 Controller");
        return Response.status(Response.Status.OK).entity(clienteCDTDigitalTypeResponse).build();
    }

    @Override
    public Response eliminarClienteCDT(Integer idCliente) {
        LOG.info("Inicia el metodo buscarClienteCDTDigital_1 Controller");
        try{
            clienteCDTDigitalImpl.eliminarClienteCDT(idCliente);
        }catch(ApplicationException e){
            LOG.error("Se presento un error en el metodo buscarClienteCDTDigital_1 controller"+ e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        LOG.info("Finaliza el metodo buscarClienteCDTDigital_1 Controller");
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @Override
    public Response crearClienteCDTDigital(ClienteCDTDigitalType clienteCDTDigitalType) {
        LOG.info("Inicia el metodo crearClienteCDTDigital Controller");
        ClienteCDTDigitalType clienteCDTDigitalTypeResponse = null;
        try{
            clienteCDTDigitalTypeResponse = clienteCDTDigitalImpl.crearClienteCDTDigital(clienteCDTDigitalType);
        }catch(ApplicationException e){
            LOG.error("Se presento un error en el metodo crearClienteCDTDigital controller"+ e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        LOG.info("Finaliza el metodo crearClienteCDTDigital Controller");
        return Response.status(Response.Status.CREATED).entity(clienteCDTDigitalTypeResponse).build();
    }

    @Override
    public Response editarClienteCDTDigital(Integer idCliente, ClienteCDTDigitalType clienteCDTDigitalType) {
        LOG.info("Inicia el metodo crearClienteCDTDigital Controller");
        ClienteCDTDigitalType clienteCDTDigitalTypeResponse;
        try{
            clienteCDTDigitalTypeResponse = clienteCDTDigitalImpl.editarClienteCDTDigital(idCliente, clienteCDTDigitalType);
        }catch(ApplicationException e){
            LOG.error("Se presento un error en el metodo crearClienteCDTDigital controller"+ e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        LOG.info("Finaliza el metodo crearClienteCDTDigital Controller");
        return Response.status(Response.Status.OK).entity(clienteCDTDigitalTypeResponse).build();
    }
}