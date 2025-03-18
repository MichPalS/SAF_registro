package com.example.demo.DTO;


public class CaracteristicasSafDTO {
    private Long idCaracteristica;
    private Long idPaciente;
    private Boolean tromboembolismoVenoso;
    private Boolean evc;
    private Boolean infartoMiocardio;
    private Boolean aborto;
    private Boolean obito;
    private Boolean preeclampsiaEclampsia;
    private String otrasManifestaciones;
    private String manifestacionesNoCriterio;
    
    public Long getIdCaracteristica() {
        return idCaracteristica;
    }
    public void setIdCaracteristica(Long idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }
    
    public Long getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
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
   

    

   
}

