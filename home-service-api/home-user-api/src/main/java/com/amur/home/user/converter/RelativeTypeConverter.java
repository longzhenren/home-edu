package com.amur.home.user.converter;

import com.amur.home.common.Constants.UserRelativeType;
import com.amur.home.user.rpc.UserServiceProto;

public class RelativeTypeConverter {
    public static UserRelativeType toEnum(UserServiceProto.UserRelativeType proto) {
        int value = proto.getNumber();
        switch (value) {
            case 0:
                return UserRelativeType.FATHER;
            case 1:
                return UserRelativeType.MOTHER;
            case 2:
                return UserRelativeType.SON;
            case 3:
                return UserRelativeType.DAUGHTER;
            case 4:
                return UserRelativeType.GRANDFATHER;
            case 5:
                return UserRelativeType.GRANDMOTHER;
            case 6:
                return UserRelativeType.BROTHER;
            case 7:
                return UserRelativeType.SISTER;
            case 8:
                return UserRelativeType.UNCLE;
            case 9:
                return UserRelativeType.AUNT;
            default:
                return UserRelativeType.OTHER;
        }
    }

    public static UserServiceProto.UserRelativeType toProto(UserRelativeType entityType) {
        int value = entityType.getValue();
        switch (value) {
            case 0:
                return UserServiceProto.UserRelativeType.FATHER;
            case 1:
                return UserServiceProto.UserRelativeType.MOTHER;
            case 2:
                return UserServiceProto.UserRelativeType.SON;
            case 3:
                return UserServiceProto.UserRelativeType.DAUGHTER;
            case 4:
                return UserServiceProto.UserRelativeType.GRANDFATHER;
            case 5:
                return UserServiceProto.UserRelativeType.GRANDMOTHER;
            case 6:
                return UserServiceProto.UserRelativeType.BROTHER;
            case 7:
                return UserServiceProto.UserRelativeType.SISTER;
            case 8:
                return UserServiceProto.UserRelativeType.UNCLE;
            case 9:
                return UserServiceProto.UserRelativeType.AUNT;
            default:
                return UserServiceProto.UserRelativeType.OTHER;
        }
    }
}
