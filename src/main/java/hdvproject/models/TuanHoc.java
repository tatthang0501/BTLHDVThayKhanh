
package hdvproject.models;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Id;


import lombok.Data;

@Data

public class TuanHoc implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private int id;

    @Column(name="ten")
    private int ten;

    @Column(name="mota")
    private String mota;

}
