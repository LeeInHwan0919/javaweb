<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>

<c:catch var="err">
<c:set var="weatherURL" value="https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=${zone}"/>
<c:import var="wrd" url="${weatherURL}"/>
<x:parse var="w" xml="${wrd}"/>
{"x":"<x:out select="$w/rss/channel/item/description/header/x"/>",
"y":"<x:out select="$w/rss/channel/item/description/header/y"/>",
"pubDate":"<x:out select="$w/rss/channel/pubDate"/>",
"wfKor":"<x:out select="$w/rss/channel/item/description/body/data/wfKor"/>",
"temp":"<x:out select="$w/rss/channel/item/description/body/data/temp"/>",
"reh":"<x:out select="$w/rss/channel/item/description/body/data/reh"/>",
"pop":"<x:out select="$w/rss/channel/item/description/body/data/pop"/>"
}
</c:catch>
<c:if test="${err != null}">
${err}
</c:if>


