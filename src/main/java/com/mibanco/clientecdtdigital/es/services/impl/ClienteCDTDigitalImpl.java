package com.mibanco.clientecdtdigital.es.services.impl;

import com.mibanco.clientecdtdigital.es.controller.ClienteCDTDigidalController;
import com.mibanco.clientecdtdigital.es.dao.ClienteCDTDigitalDao;
import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import com.mibanco.clientecdtdigital.es.services.contract.IClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.utils.exception.ApplicationException;
import com.mibanco.clientecdtdigital.es.utils.mapper.ClienteCDTDigitalMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mibanco.clientecdtdigital.es.constant.Constant.ERROR_SERVICIO;

@ApplicationScoped
public class ClienteCDTDigitalImpl implements IClienteCDTDigital {
    private  static  final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigidalController.class);
    @Inject
    ClienteCDTDigitalMapper clienteCDTDigitalMapper;
    @Inject
    ClienteCDTDigitalDao clienteCDTDigitalDao;

    @Transactional
    public ClienteCDTDigitalType crearClienteCDTDigital(ClienteCDTDigitalType clienteCDTDigitalType) {
        LOG.info("Inicia el metodo crearClienteCdtDigital Impl");
        try {
            ClienteCDTDigital clienteCDTDigital = clienteCDTDigitalMapper.clienteCDTDigitalTypeToEntity(clienteCDTDigitalType);
            clienteCDTDigitalDao.persist(clienteCDTDigital);
        }catch(ApplicationException e){
            LOG.error("Se presento un error en el metodo crearClienteCdtDigital Impl"+ e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
        LOG.info("Finaliza el metodo crearClienteCdtDigital Impl");
        return clienteCDTDigitalType;
    }
    @Override
    public ClienteCDTDigitalType buscarClienteCDTDigital(Integer idCliente) {
        LOG.info("Inicia el metodo buscarClienteCDTDigital Impl");
        ClienteCDTDigitalType clienteCDTDigitalType;
        try {
            clienteCDTDigitalType = clienteCDTDigitalMapper.clienteCDTDigitalEntityToType(clienteCDTDigitalDao.findById(idCliente.longValue()));
        }catch(ApplicationException e){
            LOG.error("Se presento un error en el metodo buscarClienteCDTDigital Impl"+ e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
        LOG.info("Finaliza el metodo buscarClienteCDTDigital Impl");
        return clienteCDTDigitalType;
    }
    @Transactional
    public void eliminarClienteCDT(Integer idCliente) {
        LOG.info("Inicia el metodo eliminarClienteCDT Impl");
        try {
            clienteCDTDigitalDao.deleteById(idCliente.longValue());
        }catch(ApplicationException e){
            LOG.error("Se presento un error en el metodo eliminarClienteCDT Impl"+ e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }
        LOG.info("Finaliza el metodo eliminarClienteCDT Impl");
    }

    @Transactional
    public ClienteCDTDigitalType editarClienteCDTDigital(Integer idCliente, ClienteCDTDigitalType clienteCDTDigitalType) {
        LOG.info("Inicia el metodo editarClienteCDTDigital Impl");
        ClienteCDTDigitalType clienteCDTDigitalTypeResponse;
        try {
            ClienteCDTDigital clienteCDTDigital = clienteCDTDigitalDao.findById(idCliente.longValue());
            clienteCDTDigitalTypeResponse = clienteCDTDigitalMapper.clienteCDTDigitalEntityToType(clienteCDTDigital);

            ClienteCDTDigital clienteCDTDigitalCambio = clienteCDTDigitalMapper.clienteCDTDigitalTypeToEntity(clienteCDTDigitalType);
            clienteCDTDigital.setFechaNacimientoDia(clienteCDTDigitalCambio.getFechaNacimientoDia());
            clienteCDTDigital.setFechaNacimientoMes(clienteCDTDigitalCambio.getFechaNacimientoMes());
            clienteCDTDigital.setFechaNacimientoAno(clienteCDTDigitalCambio.getFechaNacimientoAno());
            clienteCDTDigital.setTelefonoPrincipal(clienteCDTDigitalCambio.getTelefonoPrincipal());
            clienteCDTDigital.setOcupacion(clienteCDTDigitalCambio.getOcupacion());

        }catch(ApplicationException e){
            LOG.error("Se presento un error en el metodo editarClienteCDTDigital Impl"+ e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage());
        }

        LOG.info("Finaliza el metodo editarClienteCDTDigital Impl");
        return clienteCDTDigitalTypeResponse;
    }

}