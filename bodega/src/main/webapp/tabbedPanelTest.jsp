<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
  <head>
 	<style type="text/css">
		tr.odd {background-color: #EEDDEE}
		tr.even {background-color: #EEEEDD}
	</style>
    <sj:head />
  </head>
  <body>
    <sj:tabbedpanel id="mytabs" animate="true" selectedTab="2" collapsible="true" useSelectedTabCookie="true">
      <sj:tab id="productsTab" href="allProducts.action" label="Wine, Cava & Spirits"/>
      <sj:tab id="beersTab"  target="beers" label="Beers"/>
      <sj:tab id="restaurantsTab"  target="restaurants" label="Restaurants"/>
      <div id="beers">Beers</div>
      <div id="restaurants">Restaurants</div>
    </sj:tabbedpanel>
  </body>
</html>