package be.helha.groupeB5.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Evenement implements Serializable {

	@Id
	@GeneratedValue
	private Integer idEv;
	private String titre, resume;
	private double objectif, recolte;
	private Date dateEv;
	@Lob
	private byte[] image1;
	
	public Evenement(String titre, String resume, byte[] image1, double objectif, double recolte, Date dateEv) {
		super();
		this.titre = titre;
		this.resume = resume;
		this.image1 = image1;
		this.objectif = objectif;
		this.recolte = recolte;
		this.dateEv = dateEv;
	}
	
	public Evenement() {}
	
	public Integer getIdEv() {
		return idEv;
	}
	public void setIdEv(Integer id) {
		this.idEv = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}


	public String getImage1() {
		//byte barray[] = Base64.getEncoder().encode(image1);
		String imageString = new String(image1);
		if(imageString.length()>0)
		{
			return new String(image1);
		}
		System.out.println("oups");
		return "/9j/4AAQSkZJRgABAQAAAQABAAD//gA7Q1JFQVRPUjogZ2QtanBlZyB2MS4wICh1c2luZyBJSkcg\r\n" + 
				"SlBFRyB2ODApLCBxdWFsaXR5ID0gOTAK/9sAQwADAgIDAgIDAwMDBAMDBAUIBQUEBAUKBwcGCAwK\r\n" + 
				"DAwLCgsLDQ4SEA0OEQ4LCxAWEBETFBUVFQwPFxgWFBgSFBUU/9sAQwEDBAQFBAUJBQUJFA0LDRQU\r\n" + 
				"FBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQU/8AAEQgCcgJy\r\n" + 
				"AwEiAAIRAQMRAf/EAB8AAAEFAQEBAQEBAAAAAAAAAAABAgMEBQYHCAkKC//EALUQAAIBAwMCBAMF\r\n" + 
				"BQQEAAABfQECAwAEEQUSITFBBhNRYQcicRQygZGhCCNCscEVUtHwJDNicoIJChYXGBkaJSYnKCkq\r\n" + 
				"NDU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6g4SFhoeIiYqSk5SVlpeYmZqi\r\n" + 
				"o6Slpqeoqaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5ebn6Onq8fLz9PX29/j5+v/E\r\n" + 
				"AB8BAAMBAQEBAQEBAQEAAAAAAAABAgMEBQYHCAkKC//EALURAAIBAgQEAwQHBQQEAAECdwABAgMR\r\n" + 
				"BAUhMQYSQVEHYXETIjKBCBRCkaGxwQkjM1LwFWJy0QoWJDThJfEXGBkaJicoKSo1Njc4OTpDREVG\r\n" + 
				"R0hJSlNUVVZXWFlaY2RlZmdoaWpzdHV2d3h5eoKDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKz\r\n" + 
				"tLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uLj5OXm5+jp6vLz9PX29/j5+v/aAAwDAQACEQMRAD8A\r\n" + 
				"/VKiiigAooooAKKKKACiiigAooooAKWiigBKKWkoAWikpaACikpaACkoooABS0lFABS0lFAC0lFF\r\n" + 
				"ABS0lFABS0lFABRRXNfEH4k+F/hV4cn17xbrlloOlQ/eub2YIpP90Z6n2HNAHTVT1XWbDQrKS71K\r\n" + 
				"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\r\n" + 
				"qmOsX4U9VQMkSH2Jdm/4CPSvycr6U/4KJfE4fFL9rPxteRXJubPTLj+ybZs5XZCSvy+xOT+NfNdU\r\n" + 
				"gCiiimAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAV9df8\r\n" + 
				"EvPjO/wk/am0i0nmKaT4nhbR7lSRtDMVeJ/qGQD/AIEfWvkWtTwvrk/hjxLpOsW0jxXFhdxXUboc\r\n" + 
				"MrI4YEflSA/qSpK5b4WeMYPiH8NfC/ia2lWaLVtNt7zevq8asw+oJI/CupqQCiiigAooooAKKKKA\r\n" + 
				"FpKKO1ABRRR2oADRRRigAooooAWkoooAKKKKACigUUAFFGKKAFopuKKAHUUUUAFJS0lABRS0lABR\r\n" + 
				"S0UAJRRS0AFFJS0AFFFJQAtJS0UAFFFJQAUUtFACUUUUALWL418Qp4S8Ha5rj42abYzXbbumEQt/\r\n" + 
				"StmvB/27PFj+Df2R/ifexv5cs2iz2SN6GZTFx7/PQB/O5qmp3Os6ldX95KZ7u5kaWWRurMxyT+dV\r\n" + 
				"aKKsAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKK\r\n" + 
				"KKAP3s/4JXeNJ/F/7GvhWK5l86fSLm805nPXas7ugP0SRR9AK+ua/N3/AIIm+LHu/hJ488OO+5bL\r\n" + 
				"WlvUXuolhRT+GYv51+kVQAUUUUAGaKKKACiiigAooNFABRRRQAUUUUAFFFFABRRR2oAKKKKACiii\r\n" + 
				"gA/nRRRQAc0UYooAWiiigBKKWkoAWkpaSgApaKKAEpaKKAEpaKSgApaKKAEpaKKACikpaAEopaKA\r\n" + 
				"EopaSgAr5H/4KqanHpv7Fni8NIEe5ubKBATyxNwmQPwBP4V9cV8Pf8FgpJF/ZKdVHyNrNpu/76OK\r\n" + 
				"APw7oooqwCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACii\r\n" + 
				"igAooooA/UP/AIIf6nGNe+KunGQCU21jOqZ5I3Sqx/D5fzFfrFX46/8ABFCSRfjN47VR8jaNFuP/\r\n" + 
				"AG14r9iqlgFFFFIAooooAKKKKACiiigAooooAM0UUUAFFFFABRRRQAUUUUAFFFFABmjNFFABkUUU\r\n" + 
				"UAFLRRQAUlLSUALRRSUALSUtFACUtJS0AFFFFABRRSUALSUUtABRRRQAUUUUAJRRRQAV8e/8FYNH\r\n" + 
				"j1T9jDxNK27zLK+sbiPHr56qc+2GP6V9h184/wDBRDw8fEf7HPxKhVSxttPN7gf9MmEn/stAH889\r\n" + 
				"FFFWAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFF\r\n" + 
				"FFAH6df8EQdHjk8YfFHVG3eZFY2VunphpJWb8flX9a/WuvzJ/wCCIvh4xeCfiRrm07Z9Qgsg3rsj\r\n" + 
				"3/8AtSv02qWAUUUCkAUUUUAFFFFABRRRQAUUUUAFFBooAKKKKACiiigAooooAKKKKACiiigBaKSi\r\n" + 
				"gApaSigBaKSigBaSiigBaSiigBaSiigBaKKSgApaSloAKKSloAKKKKACkopaAEopaKACuU+K3hj/\r\n" + 
				"AITX4Y+LPD+zzP7U0q6stpGcmSJl/rXVUUAfyuSRtE7I6lXU4KkYINNr279tL4Zj4S/tN+PtAjj8\r\n" + 
				"mzXUpbm0QDAEEjF4x/3yRXiNUAUUUUwCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKK\r\n" + 
				"KKACiiigAooooAKKKKACiirGnWUmpaha2cQzLcSrEg92IA/nQB+5n/BI7wo3h79jzS754jG2tape\r\n" + 
				"32SMFgsnkA/+Qa+0a87/AGdvAEfwu+BfgXwtHGI207SLeOVQMfvigeU493Zz+NeiVABRRRQAUUUU\r\n" + 
				"AFFFFABRRS0AJRRRQAUUUUAFFFFABRS0lABRRRQAUUUUAFFFFABmilooASilooASiiigAxRS0lAB\r\n" + 
				"RRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAtFFFACUtJS0Afkb/wAFpPgxJpfi7wn8TbSBRaal\r\n" + 
				"GdJvpFU589FLRZ4xyiv/AN81+Zdf0S/t4fBb/he37MPi/QIIDPqtrEup6ftGWE0J3HaO5ZPMT/gd\r\n" + 
				"fzvTwSWs8kMyNHLGxR0YYKsDgg1SAjooopgFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRR\r\n" + 
				"QAUUUUAFFFFABRRRQAUUUUAFfRf7AHwZk+N37UPhPSWhWbTdOkOrahvBKiGEjr9XZBz6186V+v8A\r\n" + 
				"/wAEY/gfJ4b8DeKfiXqFq8dzrjR6dp7yDB+zxktIV9QzGPn/AKZ0mB+k2MYxx7UUUVIC0lFFABRR\r\n" + 
				"RQAUUUUAFLSUtACUtFJQAUUUUAFFFFAC0lLSUAFLRSUAFFLSUAFFLSUALRRRQAUlFFAC0lLRQAlF\r\n" + 
				"LSUAFFFFABRRRQAUUtJQAtJS0lABRRRQAUtFJQAUUUtACUtJS0AJRS0lAAQCCCMg9jX4If8ABTP9\r\n" + 
				"nk/Ar9pDUbrT7YReG/E8f9rWJjXCRuzFZovqHUt9HWv3wr50/bn/AGXbP9qL4K32lRJ5fifS1e80\r\n" + 
				"a4UDPnBf9Uc/wvgA/QUAfzyUVPe2U+m3k9pdQvb3MEjRSxSDDI4OCpHYgioKsAooooAKKKKACiii\r\n" + 
				"gAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigDsPhD8M9U+MfxN8NeDNHQtfazfR\r\n" + 
				"WivjIiVmAaRv9lVyx9ga/pS+HHgTS/hj4F0Pwro0K2+m6TapawoqgcKMZ47k5P41+eP/AASG/ZRH\r\n" + 
				"h/w6/wAZPENoRqGpo8GiRyj/AFcGSjzAYzliGAP9361+mVSwEooopAFFFFABRRRQAtJRRQAUUUUA\r\n" + 
				"FFFLQAlBoooAKKKWgBKKKKACilpKAAUUUUAFFFFABiilooAKKSigAooooAWkoooAKKKKACiiigBa\r\n" + 
				"KSigA6UtJRQAUUUtACUtFJQAtFFFABRRRQAlLSUUALSUUUAfkL/wVh/Yzl8K67c/GTwnp6/2LqMw\r\n" + 
				"/t2CAcwXDn/Xlf7rseSP4m981+alf1H+LfCmleOfDWp6BrdnHf6TqMDW9zbSjKujDB/HuD2ODX4C\r\n" + 
				"ftw/sf6v+yp8TJbdI5brwdqjvNpGoMMjZnmJyBjeuR+BFNAfNdFFFUAUUUUAFFFFABRRRQAUUUUA\r\n" + 
				"FFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFfR37DX7J+qftT/Fy3sTC0XhPSSl1rN63CrHu+WJfV3w\r\n" + 
				"cAdgScV5J8IPhJ4i+N/xB0jwf4Xs2vNU1GURrgZWJerSOeyqoJJ9BX9Cf7LX7N3h/wDZh+FVh4U0\r\n" + 
				"aMSXjATalfsB5l1cEAMxOOg6Adh9TSYHqOg6FYeGND0/R9Lto7LTNPt47W1tohhYokUKigegAAq/\r\n" + 
				"SUVIBS0lFABS0lFAC0UlFABRRRQAUtJRQAUUUUALSUUUAFFFFABRRRQAUUUUAFLSUUAFFFFAC0Um\r\n" + 
				"aKACilpKACiiigAopaSgAooooAM0UUUAFFFFABRRRQAUUUUAFFFFABRRRQAUtFFACUtFJQAtJS0l\r\n" + 
				"AC1w3xm+DXhf48eAdR8I+LdPjv8ATLtTtLKN8EmCFkjbqrDPBFdxRQB/OV+1X+yb4w/ZW8eXOk65\r\n" + 
				"Zyz6FPM/9la2i5hvIsnbyOFfGMqcEHPbmvD6/pu+MvwZ8LfHjwFqPhHxbp632mXiFQ4wJYH/AIZI\r\n" + 
				"2wdrKeR+oI4r8LP2wv2E/Gn7K2uvcvG+u+C7mVls9agj4XuEmUZ2Ng/Q4NNMD5koooqgCiiigAoo\r\n" + 
				"ooAKKKKACiiigAooooAKKKKACiiigAooooAK6b4c/DbxL8WvF1h4Z8J6Tca1rV6+2K2t1yQO7Mei\r\n" + 
				"qO7EgCuh+BfwA8Z/tEeNbbw14N0t725k+aa5f5YLZB1eR+gH6k4Fful+xv8AsW+Fv2TPB5itdur+\r\n" + 
				"Lb5VbUtakQBmOP8AVxj+GMc+5OSewCbAp/sQfsZaH+yj8PoBNDBfeOdRhVtW1UKGIY4JgjbtGp44\r\n" + 
				"+8Rk19MUUVIBRS0lABS0lFABS0lFABRS0lABRRRQAUUUUAFFFFABRRRQAUtJRQAtFJRQAtJS0lAB\r\n" + 
				"RRRQAUUUUAFFLRQAlFLSUAFFFLQAUlLSUAFFLSCgAooooAKKWkoAKKKWgBKKKWgBKKKKACiiloAK\r\n" + 
				"SlpKAFopKKAFpKWkoAKKKKACs7xH4b0rxfot3pGt6dbatpd2hjns7yJZYpFPYqRg1pUlAH5K/tj/\r\n" + 
				"APBJfUdMvdS8WfBe2N7prbp5PC/mZlh7sLcscuOpCZJ7DPFfmlreh6j4a1S403VrC50zUbdyk1pe\r\n" + 
				"QtFLGw6hlYAg/Wv6mK8H/aR/Yu+Gv7TumFfEmlCy1tFIt9bsFCXMZI/iOPnHA4Pp1FO4H86NFfbn\r\n" + 
				"7RX/AASj+KfwfN3qfhVoviD4cjy4ksIzFexr/twEnOPVWbPoOlfFd9p91pdw1veW01pOvDRToUYf\r\n" + 
				"gaYFeiiimAUUUUAFFFFABRRRQAUUUUAFFORGkcKilmJwFUZJr6L/AGev2Bvi5+0W8Nzo+iDRNBZg\r\n" + 
				"G1nWt0EGM4O1cFnIwegx70gPnNVLsFUEsTgAdTX2T+yf/wAEzviH8f5bTWvEdpc+C/BjMrfbL6Ix\r\n" + 
				"3F0nU+TE3zEY6MRtOeCcGv0S/Zh/4Jg/Db4A3NrrWtv/AMJ34qhGVvL63EdtC2OTHDubnrySfoK+\r\n" + 
				"yI41iRURQiKMBVGABSuBwXwY+BPgj4AeEoPD3gnQrbSLNFUSyouZ7lgMb5ZD8zsevJ78YrvqWkpA\r\n" + 
				"FFFFABRRRQAUUUUAFFFFAC0lFFABRRRQAUUUtACUUtJQAtJRRQAUUUUAFFFFABRRRQAUUUUALSUU\r\n" + 
				"UALRRRQAlFFFABRRRQAUUUUAFFFFABRRRQAUUUc0AFFFFABRRRQAtJS0lABRRS0AFFFFACUtFIaA\r\n" + 
				"FpOlLSUALRSUtABRRRQAUUUUAFeSfF/9lH4T/HW0eHxh4J0zUJ2yRfQRm2ugT386Mq5+hJHtXrdJ\r\n" + 
				"QB+YHxe/4Iq6VeT3F38N/Gk2mqxDJpuuJ5yL6hZFAP0yD9a+Qfif/wAEz/j38NDLKPB8/iazXlZt\r\n" + 
				"A/0xmH/XNMuPyr9/aWncD+XzxL8N/FvgxmXxB4X1rQ2XqNS0+W3x9d6iucr+qCe1huonjmhSWNxh\r\n" + 
				"kdQQR7g1w2tfs/8Aw08RStLqngLw7fyN1a40yFyfzWi4H8zFFf0c6z+xN8B9eC/avhR4WDLnDW+n\r\n" + 
				"JCefUoBn8ap6V+wj8AdHuFnh+FXhyWRc4+02YmH5NkfpRcD+dKtLRfDWr+JbgQaRpV7qs5OPLsrd\r\n" + 
				"5mz9FBr+kjTv2ZfhLpEivZfDbwvaOvIaHSYVI/Ja73S9C07Q7YW+nWFtYwDpFbxKi/kBRcD+eX4c\r\n" + 
				"/sIfHb4nToumfDjW7CFyMXOs2r2EWPUNMFBH0r60+GH/AARU8S6i8c/jzxraaRBxvtNJi86b3G9v\r\n" + 
				"lH5Gv106UtFwPm74Mf8ABPb4HfBGSO70vwfDrOrIMf2jrzG9kz6hH/dqfdVBr6Ngt4rSGOGCJIYU\r\n" + 
				"G1I41Cqo9AB0p9FIBaKTvRQAtJRRQAtJRS0AJRRRQAtJRS0AJRRRQAUUUtABSUUtACUtJRQAUUUU\r\n" + 
				"AFLSUUAFFFFAC0lLRQAlFFFABRRRQAUtJRQAtFFFACUUUtACUUUUAFFFFABRRRQAUUUUAFFFFABS\r\n" + 
				"0lLQAlFFLQAlFLSUAFLSUtABRSUtACUtFFACUUtFACUtFJQAUUtJQAtJRS0AFJRS0AJRS0lAC0UU\r\n" + 
				"UAFFJRQAUUtJQAUtFJQAUUtJQAUUUUAFFFFABRRS0AJRRS0AJRRRQAUUUtACUUUUAFLSUUAFFFFA\r\n" + 
				"BRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAtFJRQAUUUUAFFFFAC0lFFABRRR+NABRRRQAtJR\r\n" + 
				"S0AJRRRQAUUUUALSUUUAFLSUUALRRRQAlLRRQAUUUUAJS0UlAC0lLRQAUlLRQAlLRSUAFLRRQAlL\r\n" + 
				"SUtACUUtJQAUUUtACUUtJQAUUUUAFFFLQAlFFFABRRS0AJRRS0AJRS0UAJRRS0AJRRS0AJRRRQAU\r\n" + 
				"ZopaAEoopaAEopaSgAooooAKKWkoAKKWkoAKKWigBKKWigBKKWigBKKKM0AFFFFAC0lFFABRRRQA\r\n" + 
				"UUtJQAtJRRQAUUUtACUUUUAFFFFABRRRQAUtFFABSUtFABRRSUALSUtFABSUtFACUtFFACUUtFAB\r\n" + 
				"SUtFABRRRQAlFFFABS0lFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFLQAlFFLQAlFFLQAlLSUUAFFF\r\n" + 
				"FABRRS0AJRRS0AJRRRQAUUUUAFFLSUAFFLSUAFFFLQAlFFFABRS0UAFJS0lABRRS0AFJRRQAUUUU\r\n" + 
				"AFFFFAB+NFFFABRRRQAUUUUAFFFBoAKKKKAFoopKAFopKKAFoopKAForyL4v/tZfCb4F2s0ni/xt\r\n" + 
				"pljcx5H9nwS/aLsn08mPc4/EAV8QfFX/AILWaNYzXVr8PfBFxqgUFYtQ1mXyEY/3hGuWx7HFAH6d\r\n" + 
				"015o4gS7qoHJLHGK/Az4o/8ABTr49fEoSQxeK38LWTZCxaAv2WRc/wDTVcP+tfPXiX4teOPGe7/h\r\n" + 
				"IPGXiDXd3X+0tUnuM/8AfbmnYD+kPXPjj8PPDUrR6r420HT5F6rcahEhH5tXKap+2N8DtFgeW7+K\r\n" + 
				"3hSNU6quqROx+igkn8BX83lFFgP6Hn/4KDfs9oxH/Cz9FOO4kbH8qT/h4R+z3/0U7R/++2/wr+eK\r\n" + 
				"inYD+h3/AIeEfs9/9FO0b/vtv8KP+HhH7Pf/AEU7Rv8Avtv8K/nioosB/Q7/AMPCP2e/+inaN/32\r\n" + 
				"3+FH/Dwj9nv/AKKdo/8A323+FfzxUUWA/od/4eEfs9/9FO0f/vtv8KP+HhH7Pf8A0U7R/wDvtv8A\r\n" + 
				"Cv54qKLAf0O/8PCP2e/+inaP/wB9t/hR/wAPCP2e/wDop2jf99t/hX88VFFgP6Hf+HhH7Pf/AEU7\r\n" + 
				"Rv8Avtv8KP8Ah4R+z3/0U7R/++2/wr+eKiiwH9Dv/Dwj9nv/AKKdo/8A323+FH/Dwj9nv/op2jf9\r\n" + 
				"9t/hX88VFFgP6N9F/bc+A2vBvsvxX8LhlxlLjUEhb8A5GfwrqdM/aN+FmsyLHYfELw3du3RYdTiY\r\n" + 
				"n8mr+Z+ilYD+pyx1Sy1O3S4s7uC6gf7skMgZT9CDVmv5ctA8ZeIPCkok0TXNS0eQHIfT7uSA/mhF\r\n" + 
				"e3fDb9v348/DC5R7H4i6xq8KnP2fXrl9QjI9AJi2B9MUWA/ogor8kfhl/wAFrtdsVjt/Hfga31NA\r\n" + 
				"RuvNIn8qQjv+7b5c/iK+2/gx/wAFDfgd8bDHbad4wt9D1VgM6dr4+xvk9ld8Ix9lY0gPpKio7e4i\r\n" + 
				"u4I5oJUmhkUMkkbBlYHoQR1FSUAFLRRQAUlFFAC0lFFAC0lFLQAlFFFABS0lFABRRRQAUtJRQAtJ\r\n" + 
				"S0lAC0lFFABS0lFABRRRQAtFFFACUUtJQAUUtJQAUZpaQ0AFFFFABRRRQAtJRRQAUUUUAFFFFABR\r\n" + 
				"RRQAUtJRQAUtJRQAUVy/xI+J3hb4Q+FLvxJ4v1u00HR7YfNcXcoTe2CQiA8sxwcKMk+lfkX+1n/w\r\n" + 
				"Vk8WfEiS+8O/C1p/CPhtgYm1VflvrkZPKt1iBGMbcN15oA/Q79pX9vT4Xfs0209tqupjXPEqg+Xo\r\n" + 
				"WmOrTbuOJG5EY56kE+xr8tf2if8AgqZ8WPjW1xp+gyR+APDb/KLTTJDJcyDJ/wBZOQCe33VWvji7\r\n" + 
				"vJ9Qupbm6nkubiVi8k0zl3dj1JJ5J96hqrAT3l9c6jO013cS3UzdZJnLsfxNQUUUwCiiigAooooA\r\n" + 
				"KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKcjtGwZGKsDkEHBFNooA+gfgB+3R\r\n" + 
				"8W/2dbqBNA8QNqWio4Mmjavme2dc5IHIZM88qRX6h/s0/wDBVr4cfGee30fxfbj4f+IpMIgubjzb\r\n" + 
				"KZsc7ZSq7Tn+Fh3HJr8O6KVgP6oba6hvbeKe3lSeCRQ6SRsGVlPQgjqKkr+f/wDZY/4KFfEr9mme\r\n" + 
				"10wX8vibwasi+ZomoyGQRJnnyHPMfGcAHbnqK/Zn9mr9rPwB+1F4aXUPCuqxLqsSBr3Q7iQLd2p4\r\n" + 
				"BJTqVycbwMe9SB7PRRRQAUUUUAFFLSUAFLSUUAFFFFABS0lFABRRRQAUUtJQAUUd6KACiiigBaSi\r\n" + 
				"igBaKTPvRQAUUUUAFFFFABRS0lABRRRQAUUUUAFFFFABRRRQAdaKKKACiiigAFFFFABXhf7Vv7XX\r\n" + 
				"g/8AZS8FPqmuP/aOt3CH+ztEgkCzXL9iSfuJnq2D7A1kftn/ALZfhv8AZK8DJc3DRal4u1IMmlaM\r\n" + 
				"rfM5A5lkHVY1OBnuSAO+PwY+Lnxe8VfHHx1qPi3xhqs2ravevktIcJEg+7HGo4RFHAAHv1JNMDsv\r\n" + 
				"2lf2rfHX7Ufiw6v4rvRFZRE/Y9ItSRbWqnsoJ5Pqx6141RRVAFFFFABRRRQAUUUUAFFFFABRRRQA\r\n" + 
				"UUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFdL8O/iP4j+FPiyx8SeFtUn\r\n" + 
				"0jWLNw8U8DY+oI7g9CK5qigD9x/2GP8AgpBo37RyQeE/GMVv4e8fRqFjKPi21If3o88q/qhz7HnA\r\n" + 
				"+3q/lisL+60q9gvLK5ls7uBxJFPA5SSNgchlYcgg9xX7Kf8ABO7/AIKMp8ZfsPw5+JN/HD42WPZY\r\n" + 
				"arNtjXVNv8DYwBNjnoN2D36y0B+hNFFFIAopaKAEpaKKAEpaKSgAopaSgAopaSgAopaSgAoopaAC\r\n" + 
				"koooAKKWigAooooASiiigAooooAKKKKACijFFABRRRQAUUtIKACiiigAooooAKKKKACvE/2sf2pf\r\n" + 
				"Dn7KvwzuvEWr/wCmarMrR6XpUZAe6nx8oJ/hQHBZuwzgE8V6h438aaP8OvCeqeJNfvYtO0jTYWnu\r\n" + 
				"LmZsKqj+pOAB6mv56f2wP2odc/am+Leo+Ib2aSLQbdzBo+m5IS2txwDj+82NzE92PQYAYHBfGL4v\r\n" + 
				"+Jfjn4+1Lxf4qvmvdUvXz/sRJ/DGg7KOwriaKKoAooooAKKKKACiiigAooooAKKKKACiiigAoooo\r\n" + 
				"AKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACrGn39zpV9b3tnO9td28iy\r\n" + 
				"xTRnDI6nIYHsQRVeigD9vf8AgnJ+3rB+0D4fi8DeMpxB8QNNjxFcNgJqcAHDj0kHIYd8Ag8kD7or\r\n" + 
				"+XjwN441z4beK9N8SeHNQm0vWdOmWa3uoTgqwP5EeoPBr+hj9kL9p3R/2pvhHp/iWzeCDW4VWHV9\r\n" + 
				"OiPNrcY54PIVsEqfTvUsD2+iiikAUtFJQAUUUUAFFLSUAFLSUUAFFLSUAFFLSUAFFFFABRRS0AJm\r\n" + 
				"ilooASiiigAopaSgBaSiigAooooAKKKKACilpKACiiigAooooAKKK8T/AGyPj3H+zh+z74o8Xxug\r\n" + 
				"1dYPsmlRuMhruT5IzjuFJ3keimgD89P+Cvn7VR8SeJbP4PeHbxjp2lN9q1x4yNstyR+7iyDzsUkn\r\n" + 
				"3celfmjV/XdbvfEus3uq6lcPd395K0080jEs7sckkmqFUAUUUUwCiiigAooooAKKKKACiiigAooo\r\n" + 
				"oAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACvo39\r\n" + 
				"hD9pu5/Zk+O2k6tczyf8ItqbCw1mBOQYXOBJj1RtrfRSO9fOVFID+p7T7+31Wxt7y0lS4tbiNZYp\r\n" + 
				"YzlXUjIIP0qevz4/4JD/ALS9z8Svhlqvw5167+0az4XZZLCRyd8ti/RSSeSjhufR1Hav0HqQCiii\r\n" + 
				"gAooooAKKKKAFpKKKAFpKKKAClpKKAFpKWkoAKWkooAWikooAWkoooAWkoooAWkoooAKKKO9ABRR\r\n" + 
				"RQAUUUUAFFFFABRRRQAV+KX/AAVx/aLHxK+M0Xw+0u58zRfCLGO42/de9I/efimSn1Br9fvi98Qr\r\n" + 
				"L4UfDHxL4u1CRI7bSLGW5JkOASF+UficD8a/mf8AFvie+8a+KtZ8Q6nJ52pareTX1zJ/ellcux/N\r\n" + 
				"jTQGTRRRVAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFF\r\n" + 
				"FFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQB65+yp8crz9nf44+HPGdsXNtbzeTewp1lt3I\r\n" + 
				"Eiflj8q/o90TWbPxHo1hq2nXC3Wn39vHdW06fdkidQyMPYgg/jX8s1fvH/wSz+NJ+K37Lej6Xd3C\r\n" + 
				"Tat4Ub+x5VDZYQoP3BP/AGz2j/gNSwPsOkoopAFFFFAC0lFFABRRRQAUUtJQAUUUUALSUUUALSUU\r\n" + 
				"UALRSUUAFFFFABRRRQAUUUUAFFFFABRRRQAUdaKKACiiigAooooA/Pv/AILJfFibwf8AA7w94OtL\r\n" + 
				"jyZ/FF9I0wU/M0EAQsv0JlT8q/F6vvH/AILF/EV/FX7TOn+G0cG08N6RHFsB6TTM0jn/AL58r8q+\r\n" + 
				"DqpAFFFFMAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAoo\r\n" + 
				"ooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACvvj/gjv8WJvCf7RNz4MluNth4osZVSFjx58\r\n" + 
				"KNKGHvtRh+NfA9el/s0/ECX4W/H/AMAeKY3Ea6frNs8xJwPJZwko/FGYUgP6W6SmQTLcQRyr911D\r\n" + 
				"D6EU+pAKWkooAWkopaACkoooAKKWkoAWk7UUUALSUtJQAUUUUALRSYooAKKKKACiiigAoooxQAUU\r\n" + 
				"YooAKKKKACiiigAooxRQAUUVl+KtTOieGNY1FfvWlnNcD6ohb+lAH87H7aPil/GX7U/xK1V5mnMm\r\n" + 
				"ryRBmbOBGBGB9AEx+FeK1r+L759T8Wa1dyMWee9mlYk5JJcn+tZFUAUUUUwCiiigAooooAKKKKAC\r\n" + 
				"iiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKK\r\n" + 
				"KKACiiigAooooAKUEqQQcEdCKSigD+mX9n3xQ3jT4IeBtbeUzve6RbytKxyWOwAknv0r0Cvlj/gm\r\n" + 
				"V4hk1/8AY48ErKxY2AmswSc8K+4f+hV9T1AC0lLSUAFFFLQAlLRSUAFLRSUAFFFLQAlFLSUAFLSU\r\n" + 
				"UAFFLRQAlFFFAC0lLSUALSUtJQAUUUUAFFFFABRiiigAoo60UAFcf8ZLn7H8IfHNxnHlaFfPn6W7\r\n" + 
				"muwrzT9pu4ktf2cvilLExSRfC+plWHUH7LJQB/NZeyedeTydd8jN+ZqCiirAKKKKACiiigAooooA\r\n" + 
				"KKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAo\r\n" + 
				"oooAKKKKACiiigAooooAKKKKAP3S/wCCRl79s/ZBtFznyNZu4vphYj/WvtOvgv8A4Iy3Ekv7K+sx\r\n" + 
				"sxKR+KLoID2Bgtif1r70qAFpKKKACilooASilpKACiiigBaKSigBaSlpKAFopKWgAooooASiiigA\r\n" + 
				"ooooAKDRRQAUZoooAKKMUUAFFFFABRRRQAV5h+1F/wAm2fFT/sV9T/8ASWSvT68w/ai5/Zs+Kn/Y\r\n" + 
				"r6n/AOkslAH81NFFFWAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFF\r\n" + 
				"ABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAftb/AMEYf+TXNd/7\r\n" + 
				"Gi5/9J7avvmvgb/gjD/ya5rv/Y0XP/pPbV98VABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAC0UlFA\r\n" + 
				"C0UlFABRRRQAUUUUAFFLSUAFFFFABRRRQAUUUUAFFFFABXmH7UX/ACbZ8VP+xX1L/wBJZK9PrzD9\r\n" + 
				"qL/k2z4qf9ivqf8A6SyUAfzU0UUVYBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFF\r\n" + 
				"ABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQB+1v8A\r\n" + 
				"wRh/5Nb13/saLn/0ntq++K+B/wDgjD/ya3rv/Y0XP/pPbV98VABR2oo7UAFFFFABRRRQAUUUUAFF\r\n" + 
				"FFABRS0lABRRRQAUUUUAFLRSUAFFFFAC0lFBoAKKKKACjrRRQAUUUUAFFFFABXmH7Uf/ACbX8VP+\r\n" + 
				"xX1L/wBJZK9PrzD9qL/k2z4qf9ivqX/pLJQB/NTRRRVgFFFFABRRRQAUUUUAFFFFABRRRQAUUUUA\r\n" + 
				"FFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAU\r\n" + 
				"UUUAFFFFAH7W/wDBGH/k1zXf+xouf/Se2r74r4H/AOCMP/Jrmu/9jRc/+k9tX3zUAJRRRQAtJRRQ\r\n" + 
				"AUUUUALSUUUALSUUtABSUtJQAtFJS0AFFFFACUUUUAFLSUUAFHalpDQAUUUUAFFHNFAC0lFFABRR\r\n" + 
				"RQAV5h+1F/ybZ8VP+xX1P/0lkr0+vMP2ov8Ak2z4qf8AYr6n/wCkslAH81NFFFWAUUUUAFFFFABR\r\n" + 
				"RRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFF\r\n" + 
				"FABRRRQAUUUUAFFFFABRRRQAUUUUAftb/wAEYf8Ak1zXf+xouf8A0ntq++a+Bv8AgjD/AMmua9/2\r\n" + 
				"NFz/AOk9tX3xUAFLSUtACUUUtABRSUUAFFFFAC0UlFAC0lLSUALSUUUALRRRQAlFFFABRRQaACii\r\n" + 
				"igAo70UUAFFFFABRRRQAUUUUAFeYftRf8m1/FT/sV9S/9JZK9PrzD9qL/k2z4qf9ivqf/pLJQB/N\r\n" + 
				"TRRRVgFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAB\r\n" + 
				"RRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAH7W/8EYf+TXNd/wCxouf/AEntq++K\r\n" + 
				"+B/+CMP/ACa5rv8A2NFz/wCk9tX3xUAFFFFABRRRQAtJRRQAUUUtACUUUUAFFFFABRRS0AFFJiig\r\n" + 
				"AooooAKKKKACiiigAooooAKKKKACiiigAooooADXmH7Uf/JtnxU/7FfUv/SWSvT68w/ai/5Ns+Kn\r\n" + 
				"/Yr6l/6SyUAfzU0UUVYBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUU\r\n" + 
				"UAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQB+1v/BGH/k1vXf8A\r\n" + 
				"saLn/wBJ7avvivgf/gjD/wAmua7/ANjRc/8ApPbV98VABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFA\r\n" + 
				"BRRRQAUUtFACUUUtACUUUtACUUUUAFFFFABRRRQAUUUUAFFFFABXmH7UX/JtfxU/7FfU/wD0lkr0\r\n" + 
				"+vMf2ov+TbPip/2K+p/+kslAH81FFFFWAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAB\r\n" + 
				"RRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAft\r\n" + 
				"b/wRh/5Nc13/ALGi5/8ASe2r74r4H/4Iw/8AJrmu/wDY0XP/AKT21ffNQAUlFFAC0lFFABRRRQAt\r\n" + 
				"JRRQAUUUUAFFFFAC0lFLQAmKKM0UAFFFFAC0lFFABRRRQAUUUUAHeiiigAozRRQAUUUUAFeYftRf\r\n" + 
				"8m2fFT/sV9T/APSWSvT68w/ai/5Ns+Kn/Yr6n/6SyUAfzU0UUVYBRRRQAUUUUAFFFFABRRRQAUUU\r\n" + 
				"UAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQ\r\n" + 
				"AUUUUAFFFFABRRRQB+1v/BGH/k1vXf8AsaLn/wBJ7avvivgf/gjD/wAmua7/ANjRc/8ApPbV98VA\r\n" + 
				"C0UlFAC0lFFAC0lFFAC0UlFABS0lFABRRRQAtFJRQAtFFFABSUUUAFLSUUALSUUUAFFFFABQaKKA\r\n" + 
				"CgUUUAHaiiigArzD9qL/AJNs+Kn/AGK+p/8ApLJXp9eYftRf8m2fFT/sV9T/APSWSgD+amiiirAK\r\n" + 
				"KKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAoo\r\n" + 
				"ooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAP2t/4Iw/8mt67/2NFz/6T21ffNfA3/BGH/k1\r\n" + 
				"vXf+xouf/Se2r75qAEooooAKKKKACiiigAoopaAEoopaACkpaSgAooooAKKWigBKKKKACijFFABR\r\n" + 
				"RRQAUUUYoAKKKKACiiigAooooAK8w/ai/wCTbPip/wBivqf/AKSyV6fXmH7UX/JtnxU/7FfUv/SW\r\n" + 
				"SgD+amiiirAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAK\r\n" + 
				"KKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAP2t/4Iw/8mua7/2NFz/6T21f\r\n" + 
				"fNfA3/BGL/k1zXf+xouf/Se2r74qAFpKKKAFpKKKACiiigAooooAKWkooAKDRRQAtJRRQAtFJn3o\r\n" + 
				"oAWkoooAKKKKACiiigAooooAKKKKACiiigAooooAK8w/ai/5Ns+Kn/Yr6l/6SyV6fXmH7UX/ACbZ\r\n" + 
				"8VP+xX1P/wBJZKAP5qaKKKsAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAoooo\r\n" + 
				"AKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA/a3/gjD/wAm\r\n" + 
				"t67/ANjRc/8ApPbV9818Df8ABGH/AJNc13/saLn/ANJ7avvioAWkopaAEpaKKACkoooAWkpaKAEp\r\n" + 
				"aSigBaSlooAKSlpKAFooooAKT0oooABRRRQAtIaKKAFpPWiigA70CiigBaaKKKAF70UUUAB6V5h+\r\n" + 
				"1F/ybZ8VP+xX1L/0lkoooA/mpoooqwCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKK\r\n" + 
				"KACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigD9rf+\r\n" + 
				"CMP/ACa5rv8A2NFz/wCk9tX3zRRUAFIOlFFAB60tFFACCg0UUALRRRQAlLRRQAUnrRRQAtFFFABR\r\n" + 
				"RRQB/9k=";
	}

	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}

	public double getObjectif() {
		return objectif;
	}

	public void setObjectif(double objectif) {
		this.objectif = objectif;
	}

	public double getRecolte() {
		return recolte;
	}

	public void setRecolte(double recolte) {
		this.recolte = recolte;
	}

	public Date getDateEv() {
		return dateEv;
	}

	public void setDateEv(Date dateEv) {
		this.dateEv = dateEv;
	}
	

	public boolean equals(Object o)
	{
		if(o instanceof Evenement){
			Evenement e = (Evenement) o;
			return this.idEv.equals(e.idEv) ;
		}
		return false;
	}
/*
	@Override
	public String toString() {
		return "Evenement [idEv=" + idEv + ", titre=" + titre + ", resume=" + resume 
				+ ", objectif=" + objectif + ", recolte=" + recolte + ", dateEv=" + dateEv + "]";
	}*/

	@Override
	public String toString() {
		return "Evenement [idEv=" + idEv + ", titre=" + titre + ", resume=" + resume + ", objectif=" + objectif
				+ ", recolte=" + recolte + ", dateEv=" + dateEv +  "]";
	}
	
	
	
	
	
	
	
}
