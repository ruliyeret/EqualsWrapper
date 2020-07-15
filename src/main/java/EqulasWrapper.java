import java.util.function.BiFunction;

public class EqulasWrapper<T extends IcustomEquals> {

    T entity;
    BiFunction<T, T, Boolean> customEquals;


    public EqulasWrapper(T entityClass, BiFunction<T, T, Boolean> func){
        this.entity = entityClass;
        this.customEquals = func;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqulasWrapper<T> that = (EqulasWrapper<T>) o;
        return this.customEquals.apply(this.entity, that.entity);
    }

    @Override
    public int hashCode() {
        return entity.getCustomHashCode();
    }
}
