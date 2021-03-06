PGDMP     ,                     z            catalogo    14.1    14.1 6    7           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            8           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            9           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            :           1262    28390    catalogo    DATABASE     d   CREATE DATABASE catalogo WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE catalogo;
                postgres    false            ?            1259    34173    autore_libro    TABLE     b   CREATE TABLE public.autore_libro (
    autore_id bigint NOT NULL,
    libro_id bigint NOT NULL
);
     DROP TABLE public.autore_libro;
       public         heap    postgres    false            ?            1259    34177    autori    TABLE     |   CREATE TABLE public.autori (
    id bigint NOT NULL,
    cognome character varying(255),
    nome character varying(255)
);
    DROP TABLE public.autori;
       public         heap    postgres    false            ?            1259    34176    autori_id_seq    SEQUENCE     v   CREATE SEQUENCE public.autori_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.autori_id_seq;
       public          postgres    false    212            ;           0    0    autori_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.autori_id_seq OWNED BY public.autori.id;
          public          postgres    false    211            ?            1259    34185    categoria_libro    TABLE     h   CREATE TABLE public.categoria_libro (
    categoria_id bigint NOT NULL,
    libro_id bigint NOT NULL
);
 #   DROP TABLE public.categoria_libro;
       public         heap    postgres    false            ?            1259    34189 	   categorie    TABLE     ]   CREATE TABLE public.categorie (
    id bigint NOT NULL,
    genere character varying(255)
);
    DROP TABLE public.categorie;
       public         heap    postgres    false            ?            1259    34188    categorie_id_seq    SEQUENCE     y   CREATE SEQUENCE public.categorie_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.categorie_id_seq;
       public          postgres    false    215            <           0    0    categorie_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.categorie_id_seq OWNED BY public.categorie.id;
          public          postgres    false    214            ?            1259    34172    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?            1259    34196    libri    TABLE     ?   CREATE TABLE public.libri (
    id bigint NOT NULL,
    anno integer NOT NULL,
    prezzo double precision NOT NULL,
    titolo character varying(255)
);
    DROP TABLE public.libri;
       public         heap    postgres    false            ?            1259    34202    libri_autori    TABLE     b   CREATE TABLE public.libri_autori (
    id_libro bigint NOT NULL,
    id_autore bigint NOT NULL
);
     DROP TABLE public.libri_autori;
       public         heap    postgres    false            ?            1259    34205    libri_categorie    TABLE     h   CREATE TABLE public.libri_categorie (
    id_libro bigint NOT NULL,
    id_categoria bigint NOT NULL
);
 #   DROP TABLE public.libri_categorie;
       public         heap    postgres    false            ?            1259    34195    libri_id_seq    SEQUENCE     u   CREATE SEQUENCE public.libri_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.libri_id_seq;
       public          postgres    false    217            =           0    0    libri_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.libri_id_seq OWNED BY public.libri.id;
          public          postgres    false    216            ?            1259    34208    role    TABLE     W   CREATE TABLE public.role (
    id integer NOT NULL,
    name character varying(255)
);
    DROP TABLE public.role;
       public         heap    postgres    false            ?            1259    34213    user_reg    TABLE     ?   CREATE TABLE public.user_reg (
    id integer NOT NULL,
    email character varying(255),
    is_active boolean NOT NULL,
    password character varying(255),
    user_name character varying(255)
);
    DROP TABLE public.user_reg;
       public         heap    postgres    false            ?            1259    34220 	   user_role    TABLE     ^   CREATE TABLE public.user_role (
    user_id integer NOT NULL,
    role_id integer NOT NULL
);
    DROP TABLE public.user_role;
       public         heap    postgres    false            ?           2604    34180 	   autori id    DEFAULT     f   ALTER TABLE ONLY public.autori ALTER COLUMN id SET DEFAULT nextval('public.autori_id_seq'::regclass);
 8   ALTER TABLE public.autori ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    212    212            ?           2604    34192    categorie id    DEFAULT     l   ALTER TABLE ONLY public.categorie ALTER COLUMN id SET DEFAULT nextval('public.categorie_id_seq'::regclass);
 ;   ALTER TABLE public.categorie ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215            ?           2604    34199    libri id    DEFAULT     d   ALTER TABLE ONLY public.libri ALTER COLUMN id SET DEFAULT nextval('public.libri_id_seq'::regclass);
 7   ALTER TABLE public.libri ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217            (          0    34173    autore_libro 
   TABLE DATA           ;   COPY public.autore_libro (autore_id, libro_id) FROM stdin;
    public          postgres    false    210   c;       *          0    34177    autori 
   TABLE DATA           3   COPY public.autori (id, cognome, nome) FROM stdin;
    public          postgres    false    212   ?;       +          0    34185    categoria_libro 
   TABLE DATA           A   COPY public.categoria_libro (categoria_id, libro_id) FROM stdin;
    public          postgres    false    213   ?;       -          0    34189 	   categorie 
   TABLE DATA           /   COPY public.categorie (id, genere) FROM stdin;
    public          postgres    false    215   ?;       /          0    34196    libri 
   TABLE DATA           9   COPY public.libri (id, anno, prezzo, titolo) FROM stdin;
    public          postgres    false    217   <       0          0    34202    libri_autori 
   TABLE DATA           ;   COPY public.libri_autori (id_libro, id_autore) FROM stdin;
    public          postgres    false    218   9<       1          0    34205    libri_categorie 
   TABLE DATA           A   COPY public.libri_categorie (id_libro, id_categoria) FROM stdin;
    public          postgres    false    219   ^<       2          0    34208    role 
   TABLE DATA           (   COPY public.role (id, name) FROM stdin;
    public          postgres    false    220   ?<       3          0    34213    user_reg 
   TABLE DATA           M   COPY public.user_reg (id, email, is_active, password, user_name) FROM stdin;
    public          postgres    false    221   ?<       4          0    34220 	   user_role 
   TABLE DATA           5   COPY public.user_role (user_id, role_id) FROM stdin;
    public          postgres    false    222   %=       >           0    0    autori_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.autori_id_seq', 2, true);
          public          postgres    false    211            ?           0    0    categorie_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.categorie_id_seq', 2, true);
          public          postgres    false    214            @           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 3, true);
          public          postgres    false    209            A           0    0    libri_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.libri_id_seq', 1, true);
          public          postgres    false    216            ?           2606    34184    autori autori_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.autori
    ADD CONSTRAINT autori_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.autori DROP CONSTRAINT autori_pkey;
       public            postgres    false    212            ?           2606    34194    categorie categorie_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.categorie
    ADD CONSTRAINT categorie_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.categorie DROP CONSTRAINT categorie_pkey;
       public            postgres    false    215            ?           2606    34201    libri libri_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.libri
    ADD CONSTRAINT libri_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.libri DROP CONSTRAINT libri_pkey;
       public            postgres    false    217            ?           2606    34212    role role_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.role DROP CONSTRAINT role_pkey;
       public            postgres    false    220            ?           2606    34219    user_reg user_reg_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.user_reg
    ADD CONSTRAINT user_reg_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.user_reg DROP CONSTRAINT user_reg_pkey;
       public            postgres    false    221            ?           2606    34224    user_role user_role_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id);
 B   ALTER TABLE ONLY public.user_role DROP CONSTRAINT user_role_pkey;
       public            postgres    false    222    222            ?           2606    34255 +   libri_categorie fk66sjgxah7hsa2l4eccxdil560    FK CONSTRAINT     ?   ALTER TABLE ONLY public.libri_categorie
    ADD CONSTRAINT fk66sjgxah7hsa2l4eccxdil560 FOREIGN KEY (id_categoria) REFERENCES public.categorie(id);
 U   ALTER TABLE ONLY public.libri_categorie DROP CONSTRAINT fk66sjgxah7hsa2l4eccxdil560;
       public          postgres    false    219    3209    215            ?           2606    34230 (   autore_libro fk9730rwnwxe2l8cq1taskbdd2p    FK CONSTRAINT     ?   ALTER TABLE ONLY public.autore_libro
    ADD CONSTRAINT fk9730rwnwxe2l8cq1taskbdd2p FOREIGN KEY (autore_id) REFERENCES public.autori(id);
 R   ALTER TABLE ONLY public.autore_libro DROP CONSTRAINT fk9730rwnwxe2l8cq1taskbdd2p;
       public          postgres    false    210    3207    212            ?           2606    34265 %   user_role fka68196081fvovjhkek5m97n3y    FK CONSTRAINT     ?   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fka68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES public.role(id);
 O   ALTER TABLE ONLY public.user_role DROP CONSTRAINT fka68196081fvovjhkek5m97n3y;
       public          postgres    false    222    3213    220            ?           2606    34245 (   libri_autori fkcy4e5un4l2n0xq26dde9n8mo2    FK CONSTRAINT     ?   ALTER TABLE ONLY public.libri_autori
    ADD CONSTRAINT fkcy4e5un4l2n0xq26dde9n8mo2 FOREIGN KEY (id_autore) REFERENCES public.autori(id);
 R   ALTER TABLE ONLY public.libri_autori DROP CONSTRAINT fkcy4e5un4l2n0xq26dde9n8mo2;
       public          postgres    false    218    3207    212            ?           2606    34270 %   user_role fkd3lcc6x4eqach91bp5edy2hia    FK CONSTRAINT     ?   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fkd3lcc6x4eqach91bp5edy2hia FOREIGN KEY (user_id) REFERENCES public.user_reg(id);
 O   ALTER TABLE ONLY public.user_role DROP CONSTRAINT fkd3lcc6x4eqach91bp5edy2hia;
       public          postgres    false    222    3215    221            ?           2606    34235 +   categoria_libro fkef9uq3i88ojrj64j5eqetmjgv    FK CONSTRAINT     ?   ALTER TABLE ONLY public.categoria_libro
    ADD CONSTRAINT fkef9uq3i88ojrj64j5eqetmjgv FOREIGN KEY (libro_id) REFERENCES public.libri(id);
 U   ALTER TABLE ONLY public.categoria_libro DROP CONSTRAINT fkef9uq3i88ojrj64j5eqetmjgv;
       public          postgres    false    217    213    3211            ?           2606    34250 (   libri_autori fkme1f6f10tnc0sdealtffn1v1o    FK CONSTRAINT     ?   ALTER TABLE ONLY public.libri_autori
    ADD CONSTRAINT fkme1f6f10tnc0sdealtffn1v1o FOREIGN KEY (id_libro) REFERENCES public.libri(id);
 R   ALTER TABLE ONLY public.libri_autori DROP CONSTRAINT fkme1f6f10tnc0sdealtffn1v1o;
       public          postgres    false    218    3211    217            ?           2606    34240 +   categoria_libro fkpf4pkr318svm8g0yf55h3yeol    FK CONSTRAINT     ?   ALTER TABLE ONLY public.categoria_libro
    ADD CONSTRAINT fkpf4pkr318svm8g0yf55h3yeol FOREIGN KEY (categoria_id) REFERENCES public.categorie(id);
 U   ALTER TABLE ONLY public.categoria_libro DROP CONSTRAINT fkpf4pkr318svm8g0yf55h3yeol;
       public          postgres    false    213    215    3209            ?           2606    34225 (   autore_libro fkpgg55dm09qw2bt3cndp2rj9ai    FK CONSTRAINT     ?   ALTER TABLE ONLY public.autore_libro
    ADD CONSTRAINT fkpgg55dm09qw2bt3cndp2rj9ai FOREIGN KEY (libro_id) REFERENCES public.libri(id);
 R   ALTER TABLE ONLY public.autore_libro DROP CONSTRAINT fkpgg55dm09qw2bt3cndp2rj9ai;
       public          postgres    false    3211    210    217            ?           2606    34260 *   libri_categorie fkxrdupktuwtkj0bhopjod1ll1    FK CONSTRAINT     ?   ALTER TABLE ONLY public.libri_categorie
    ADD CONSTRAINT fkxrdupktuwtkj0bhopjod1ll1 FOREIGN KEY (id_libro) REFERENCES public.libri(id);
 T   ALTER TABLE ONLY public.libri_categorie DROP CONSTRAINT fkxrdupktuwtkj0bhopjod1ll1;
       public          postgres    false    219    3211    217            (      x?????? ? ?      *   -   x?3????K?.I-?H??2??M??????N?K)J?????? ??
?      +      x?????? ? ?      -   !   x?3??(???I-?2?t????K?????? bv?      /      x?3?4202??Գ??I,I-?????? 1U[      0      x?3?4?2?4?????? ??      1      x?3?4?2?4?????? ??      2   !   x?3???q?wt????2?pB?]??b???? s??      3   a   x?3?LL???sH??M???K???,?T1JT14P1?2q?M?OM)u2-??(??????s???*u6??????Ȍ??*1?4H??q??H?.??????? DX?      4      x?3?4?????? f     