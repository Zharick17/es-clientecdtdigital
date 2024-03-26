package com.mibanco.clientecdtdigital.es.utils.mapper;

import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ClienteCDTDigitalMapper {
    public ClienteCDTDigital clienteCDTDigitalTypeToEntity(ClienteCDTDigitalType clienteCDTDigitalType){
        return new ModelMapper().map(clienteCDTDigitalType, ClienteCDTDigital.class);
    }
    public ClienteCDTDigitalType clienteCDTDigitalEntityToType(ClienteCDTDigital clienteCDTDigital){
        return new ModelMapper().map(clienteCDTDigital, ClienteCDTDigitalType.class);
    }
}