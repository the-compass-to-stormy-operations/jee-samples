File mapping of hibernate - HBM
Below a exemplo.hbm.xml

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN" "http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">
<hibernate-mapping>
    <class name="" table="">
		
		<id column="" name="">	
			<generator class="sequence">
				<param name="sequence"></param>
			</generator>
		</id>
		
		<property column="" name="" type="" length="" />
		
		<set name="" lazy="true" table="">
			<key column="" />
			<many-to-many column="" class="" />
		</set>
		

    </class>
</hibernate-mapping>