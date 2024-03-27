package com.mibanco.clientecdtdigital.es.services.impl;

import com.mibanco.clientecdtdigital.es.dao.ClienteCDTDigitalGraphQlDao;
import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import com.mibanco.clientecdtdigital.es.utils.exception.ApplicationException;
import com.mibanco.clientecdtdigital.es.utils.mapper.ClienteCDTDigitalGraphQlMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@ApplicationScoped
public class ClienteCDTDigitalGraphQlImpl {
    private  static  final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigitalGraphQlImpl.class);
    @Inject
    ClienteCDTDigitalGraphQlMapper clienteCDTDigitalGraphQlMapper;
    @Inject
    ClienteCDTDigitalGraphQlDao clienteCDTDigitalGraphQlDao;

    public List<ClienteCDTDigital> obtenerTodosLosClienteCDTDigitalImpl(){
        LOG.info("Inicia el proceso de obtenerTodosLosClienteCDTDigitalImpl Impl");
        List<ClienteCDTDigital> allClient = null;
        try{
            allClient = clienteCDTDigitalGraphQlDao.listAll();
        }catch(ApplicationException e){
            LOG.error("Error en el proceso de obtenerTodosLosClienteCDTDigitalImpl Impl: " + e.getMessage());
        }
        LOG.info("Finaliza el proceso de obtenerTodosLosClienteCDTDigitalImpl Impl");
        return allClient;
    }

    @Transactional
    public ClienteCDTDigital crearClienteCDTDigitalImpl(ClienteCDTDigitalType clienteCDTDigitalType){
        LOG.info("Inicia el proceso de crearClienteCDTDigitalImpl Impl");
        ClienteCDTDigital clienteCDTDigital = null;
        try{
            clienteCDTDigital = clienteCDTDigitalGraphQlMapper.clienteCDTDigitalTypeToEntity(clienteCDTDigitalType);
            clienteCDTDigitalGraphQlDao.persist(clienteCDTDigital);
        }catch(ApplicationException e){
            LOG.error("Error en el proceso de crearClienteCDTDigitalImpl Impl: " + e.getMessage());
        }
        LOG.info("Finaliza el proceso de crearClienteCDTDigitalImpl Impl");
        return clienteCDTDigital;
    }

    @Transactional
    public void eliminarClienteCDTDigitalImpl(Long id){
        LOG.info("Inicia el proceso de crearClienteCDTDigitalImpl Impl");
        try{
            clienteCDTDigitalGraphQlDao.deleteById(id);
        }catch(ApplicationException e){
            LOG.error("Error en el proceso de crearClienteCDTDigitalImpl Impl: " + e.getMessage());
        }
        LOG.info("Finaliza el proceso de crearClienteCDTDigitalImpl Impl");
    }

}