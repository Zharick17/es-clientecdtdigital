package com.mibanco.clientecdtdigital.es.controller;

import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import com.mibanco.clientecdtdigital.es.services.impl.ClienteCDTDigitalGraphQlImpl;
import com.mibanco.clientecdtdigital.es.utils.exception.ApplicationException;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@GraphQLApi
public class ClienteCDTDigidalGraphQlController {
    private  static  final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigidalGraphQlController.class);

    @Inject
    ClienteCDTDigitalGraphQlImpl clienteCDTDigitalGraphQlImpl;

    @Query("allCliente")
    public List<ClienteCDTDigital> obtenerTodosLosClienteCDTDigitalGraphQl(){
        LOG.info("Inicia el proceso de obtenerTodosLosClienteCDTDigitalGraphQl Controller");
        List<ClienteCDTDigital> allClient = null;
        try{
            allClient = clienteCDTDigitalGraphQlImpl.obtenerTodosLosClienteCDTDigitalImpl();
        }catch(ApplicationException e){
            LOG.error("Error en el proceso de obtenerTodosLosClienteCDTDigitalGraphQl Controller: " + e.getMessage());
        }
        LOG.info("Finaliza el proceso de obtenerTodosLosClienteCDTDigitalGraphQl Controller");
        return allClient;
    }
    @Mutation("crearCliente")
    public ClienteCDTDigital crearClienteCDTDigitalGraphQl(@Name("crear") ClienteCDTDigitalType clienteCDTDigitalType){
        LOG.info("Inicia el proceso de crearClienteCDTDigitalGraphQl Impl");
        ClienteCDTDigital clienteCDTDigital = null;
        try{
            clienteCDTDigital = clienteCDTDigitalGraphQlImpl.crearClienteCDTDigitalImpl(clienteCDTDigitalType);
        }catch(ApplicationException e){
            LOG.error("Error en el proceso de crearClienteCDTDigitalGraphQl Impl: " + e.getMessage());
        }
        LOG.info("Finaliza el proceso de crearClienteCDTDigitalGraphQl Impl");
        return clienteCDTDigital;
    }

    @Mutation("eliminarCliente")
    public void  eliminarClienteCDTDigitalGraphQl(@Name("id") Integer id){
        LOG.info("Inicia el proceso de crearClienteCDTDigitalGraphQl Impl");
        try{
            clienteCDTDigitalGraphQlImpl.eliminarClienteCDTDigitalImpl(id.longValue());
        }catch(ApplicationException e){
            LOG.error("Error en el proceso de crearClienteCDTDigitalGraphQl Impl: " + e.getMessage());
        }
        LOG.info("Finaliza el proceso de crearClienteCDTDigitalGraphQl Impl");
    }
}