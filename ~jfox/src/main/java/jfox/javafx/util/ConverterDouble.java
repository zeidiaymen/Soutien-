package jfox.javafx.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


public class ConverterDouble extends Converter<Double> {

	
	// Champs
	
	private NumberFormat	format = NumberFormat.getInstance();
	
	
	// Constructeur
	
	public ConverterDouble( Locale locale, String pattern, String message ) {
		super(message);
		if ( locale != null ) {
			format = NumberFormat.getInstance( locale );
		}
		if ( format instanceof DecimalFormat && pattern != null ) {
			( (DecimalFormat) format ).applyPattern(pattern);
		}
	}

	public ConverterDouble( Locale locale, String pattern ) {
		this( locale, pattern, null );
	}

	public ConverterDouble( Locale locale ) {
		this( locale, null, null );
	}

	public ConverterDouble( String pattern, String message ) {
 		this( null, pattern, message );
	}

	public ConverterDouble( String pattern ) {
		this( null, pattern, null );
	}

	public ConverterDouble() {
		this( null, null, null );
	}
	
	
	// Actons
	
	@Override
	protected String format(Double object) {
		return format.format( object );
	}
	
	@Override
	protected Double parse(String string) throws ParseException {
		return format.parse( string ).doubleValue();
	}
	
	@Override
	public int compare( String string, Double ref ) throws ParseException {
		var value = parse( string );
		return Double.compare( value, ref );
	}
		
}
