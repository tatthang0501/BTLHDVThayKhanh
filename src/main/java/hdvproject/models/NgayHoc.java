
package hdvproject.models;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Id;

import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
public class NgayHoc implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    @NotNull
    @Column(name="ten")
    private int ten;
    @NotNull
    @Column(name="mota")
    private String mota;

}
