package com.example.demo.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "caracteristicas_saf")
public class CaracteristicasSaf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_caracteristica")
    private Long idCaracteristica;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente idPaciente;

    @Column(name = "tromboembolismo_venoso")
    private Boolean tromboembolismoVenoso;

    @Column(name = "evc")
    private Boolean evc;

    @Column(name = "infarto_miocardio")
    private Boolean infartoMiocardio;

    @Column(name = "aborto")
    private Boolean aborto;

    @Column(name = "obito")
    private Boolean obito;

    @Column(name = "preeclampsia_eclampsia")
    private Boolean preeclampsiaEclampsia;

    @Column(name = "otras_manifestaciones", columnDefinition = "TEXT")
    private String otrasManifestaciones;

    @Column(name = "manifestaciones_no_criterio", columnDefinition = "TEXT")
    private String manifestacionesNoCriterio;

    public Long getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(Long idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }
    
    public Boolean getTromboembolismoVenoso() {
        return tromboembolismoVenoso;
    }

    public void setTromboembolismoVenoso(Boolean tromboembolismoVenoso) {
        this.tromboembolismoVenoso = tromboembolismoVenoso;
    }

    public Boolean getEvc() {
        return evc;
    }

    public void setEvc(Boolean evc) {
        this.evc = evc;
    }

    public Boolean getInfartoMiocardio() {
        return infartoMiocardio;
    }

    public void setInfartoMiocardio(Boolean infartoMiocardio) {
        this.infartoMiocardio = infartoMiocardio;
    }

    public Boolean getAborto() {
        return aborto;
    }

    public void setAborto(Boolean aborto) {
        this.aborto = aborto;
    }

    public Boolean getObito() {
        return obito;
    }

    public void setObito(Boolean obito) {
        this.obito = obito;
    }

    public Boolean getPreeclampsiaEclampsia() {
        return preeclampsiaEclampsia;
    }

    public void setPreeclampsiaEclampsia(Boolean preeclampsiaEclampsia) {
        this.preeclampsiaEclampsia = preeclampsiaEclampsia;
    }

    public String getOtrasManifestaciones() {
        return otrasManifestaciones;
    }

    public void setOtrasManifestaciones(String otrasManifestaciones) {
        this.otrasManifestaciones = otrasManifestaciones;
    }

    public String getManifestacionesNoCriterio() {
        return manifestacionesNoCriterio;
    }

    public void setManifestacionesNoCriterio(String manifestacionesNoCriterio) {
        this.manifestacionesNoCriterio = manifestacionesNoCriterio;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

   
    
}
