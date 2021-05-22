
package hdvproject.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tuanhoc")
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

    @JoinColumn(name="lichhocid")
    @ManyToOne
    private LichHoc lh;
}
