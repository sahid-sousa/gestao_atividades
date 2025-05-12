package com.ufra.gestao.atividades.security

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Role implements Serializable {

	private static final long serialVersionUID = 1

	String label
	String authority

	static constraints = {
		authority nullable: false, blank: false, unique: true
	}

	static mapping = {
		cache true
	}

	static init(){
		withTransaction {
			[
			        findOrSaveWhere(authority: 'ROLE_USER', label: 'Usuario'),
					findOrSaveWhere(authority: 'ROLE_ADMIN', label: 'Administrador'),
					findOrSaveWhere(authority: 'ROLE_SECRETARIA', label: 'Secretaria'),
					findOrSaveWhere(authority: 'ROLE_SUPORTE', label: 'Suporte')
			]
		}
	}

	String toString() {
		label ?: authority
	}
}
