package com.example.bankapplication.mapper;


import com.example.bankapplication.dto.ManagerDto;
import com.example.bankapplication.entity.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;


@Mapper(componentModel = "spring")
public interface ManagerMapper {

    @Mapping(source = "id", target = "id", qualifiedByName = "uuidToString")
    ManagerDto managerToManagerDto(Manager manager);

    List<ManagerDto> managersToManagersDto(List<Manager> managers);

//    @Named("uuidToString")
//    default String uuidToString(UUID uuid) {
//        return uuid == null ? null : uuid.toString();
//    }

    @Named("uuidToString")
    default String uuidToString(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return UUID.nameUUIDFromBytes(bb.array()).toString();
    }
}
