package com.ufra.gestao.atividades.sistema

import com.ufra.gestao.atividades.security.User
import grails.core.GrailsApplication
import grails.gorm.transactions.Transactional
import org.apache.commons.io.FilenameUtils
import org.apache.tomcat.util.http.fileupload.FileUploadException
import org.springframework.web.multipart.MultipartFile

@Transactional
class DocumentoService {

    GrailsApplication grailsApplication
    def springSecurityService

    final String[] EXTENSOES_VALIDAS = ['pdf', 'png', 'jpg', 'jpeg', 'gif', 'zip']

    /**
     * Realiza e salva uma instancia de arquivo e documentacao
     * @param arquivo
     * @param documentacao
     * @return
     */

    def uploadFile(MultipartFile arquivo, Documentacao documentacao){
        if(arquivo.empty){
            throw new FileUploadException('Informe os arquivos para efetuar o upload')
        }
        else if(!isArquivoValido(arquivo.originalFilename, EXTENSOES_VALIDAS)){
            throw new FileUploadException("Extensões permitidas: ${EXTENSOES_VALIDAS.join(', ')}")
        }else{
            String extension = FilenameUtils.getExtension(arquivo.originalFilename)
            User user = springSecurityService.currentUser
            String diretorio = criaDiretorioUpload("${grailsApplication.config.upload.folder}${user.pessoa.id}")
            Documento documento = new Documento()
            documento.fileName = "${UUID.randomUUID().toString()}.${extension}"
            documento.originalFileName = arquivo.originalFilename
            documento.fullPath = "${diretorio}/${documento.fileName}"
            documento.documentacao = documentacao
            arquivo.transferTo(new File("${documento.fullPath}"))
            documento.save(failOnError: true)
        }
    }

    /**
     * Listagem de documentoa a partir de uma documentacao
     * @param documentacao
     * @param params
     * @return
     */

    List<Documento> listDocumento(Documentacao documentacao, Map params){
        Closure criteria = getCriteria(documentacao)
        Documento.createCriteria().list(params, criteria)
    }

    /**
     * Listagem de documentoa a partir de uma documentacao
     * @param documentacao
     * @param params
     * @return
     */
    List<Documento> listDocumento(Documentacao documentacao){
        Closure criteria = getCriteria(documentacao)
        Documento.createCriteria().list(criteria)
    }

    /**
     * Contagem de documentos a partir de uma documentacao
     * @param documentacao
     * @return
     */

    Long countDocumento(Documentacao documentacao){
        def criteria = getCriteria(documentacao)
        Documento.createCriteria().count(criteria)
    }

    /**
     * Cria o diretorio de upload dos arquivos
     * @return
     */

    def criaDiretorioUpload(){
        criaDiretorioUpload("${grailsApplication.config.upload.folder}")
    }

    /**
     * Cria o diretorio de upload dos arquivos
     * @return
     */
    String criaDiretorioUpload(String caminnho){
        File directory = new File(caminnho)
        if (!directory.exists()){
            directory.mkdir()
        }
        directory.path
    }

    /**
     * Verifica se a extencao do arquivos esta dentro das extensoes permitidas
     * @param nome
     * @param extencoes
     * @return
     */
    Boolean isArquivoValido(String nome, String[] extencoes){
        nome = nome.toLowerCase()
        for(String extencao in extencoes){
            if(nome.endsWith(extencao))return true
        }
        return false
    }

    /**
     * Deleta um documento
     * @param documento
     * @return
     */

    Boolean delete(Documento documento){
        Boolean resposta = false
        File file = new File(documento.fullPath)
        if(file.delete()){
            documento.delete()
            resposta = true
        }
        resposta
    }

    Closure getCriteria(Documentacao documentacao){
        return{
            eq('documentacao', documentacao)
        }
    }

}
