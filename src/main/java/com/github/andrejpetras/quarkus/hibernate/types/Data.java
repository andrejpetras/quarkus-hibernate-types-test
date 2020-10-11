package com.github.andrejpetras.quarkus.hibernate.types;

import io.quarkus.hibernate.types.json.JsonBinaryType;
import io.quarkus.hibernate.types.json.JsonTypes;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@TypeDef(name = JsonTypes.JSON_BIN, typeClass = JsonBinaryType.class)
@Entity
public class Data {

    @Id
    @Column(name = "ID")
    private String id;

    @Type(type = JsonTypes.JSON_BIN)
    @Column(name = "PARAMS", columnDefinition = JsonTypes.JSON_BIN)
    private Parameters data = new Parameters();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Parameters getData() {
        return data;
    }

    public void setData(Parameters data) {
        this.data = data;
    }
}
