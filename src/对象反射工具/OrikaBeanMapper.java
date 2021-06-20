package 对象反射工具;

import java.util.ArrayList;
import java.util.List;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * 对象映射
 *
 * maven
 * <dependency>
 *     <groupId>ma.glasnost.orika</groupId>
 *     <artifactId>orika-core</artifactId>
 *     <version>1.5.1</version>
 * </dependency>
 *
 *
 * Create by @author sharpcsu on 2021/6/20 - 12:03
 */
public class OrikaBeanMapper {

    private static final MapperFactory FACTORY;

    static {
        FACTORY = new DefaultMapperFactory.Builder().build();
    }

    public static <V, P> P convert(V base, final Class<P> target) {
        if (base == null) {
            return null;
        }

        return FACTORY.getMapperFacade().map(base, target);
    }

    public static <V, P> List<P> convertList(List<V> baseList, Class<P> target) {
        if (baseList == null) {
            return null;
        }

        List<P> targetList = new ArrayList<>();
        for (V vo : baseList) {
            targetList.add(convert(vo, target));
        }
        return targetList;
    }
}