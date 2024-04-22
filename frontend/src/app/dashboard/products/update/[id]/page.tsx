'use client';

import { ButtonRoot, ButtonText } from '@/components/ButtonRoot';
import { Header } from '@/components/header';
import {
  InputDefault,
  InputLabel,
  InputRoot,
  InputTextArea
} from '@/components/InputRoot';
import {
  ProductFiledResponse,
  ProductResponse
} from '@/http/response/ProductResponse';
import { ProductFindByIdService } from '@/services/product/ProductFindByIdService';
import { ProductUpdateService } from '@/services/product/ProductUpdateService';
import { FORMATTED_DATE } from '@/utils/format/date';
import {
  FORMAR_REAL_V1,
  FORMATBIGDECIMAL,
  FORMATREAL
} from '@/utils/format/money';
import { ChevronLeft } from 'lucide-react';
import Link from 'next/link';
import { useRouter } from 'next/navigation';

import { ChangeEvent, FormEvent, useEffect, useState } from 'react';
import { toast } from 'react-toastify';

type ParamsProps = {
  id: string;
};
type ProductsProps = {
  params: ParamsProps;
};

export default function Products({ params }: ProductsProps) {
  const [fields, setFields] = useState<ProductFiledResponse>(
    {} as ProductFiledResponse
  );
  const router = useRouter();

  const productId = params.id;

  function handleChange(
    event: ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) {
    const { name, value } = event.target;
    const field = { ...fields, [name]: value };

    setFields({
      sku: field.sku,
      name: field.name,
      price: FORMATREAL(`${field.price}`),
      description: field.description
    });
  }

  const handleSubmit = async (event: FormEvent) => {
    event.preventDefault();
    try {
      const product: ProductResponse = {
        id: +productId,
        sku: fields.sku,
        price: FORMATBIGDECIMAL(`${fields.price}`),
        name: fields.name,
        description: fields.description
      };

      await ProductUpdateService(product);

      toast.success('Produto atualizado com sucesso!');
      router.push('/dashboard/products');
    } catch (error) {
      console.log(JSON.parse(JSON.stringify(error)));
    }
  };

  useEffect(() => {
    (async function loadingProduct() {
      try {
        const response = await ProductFindByIdService(productId);
        setFields({
          id: response.id,
          sku: response.sku,
          name: response.name,
          price: FORMAR_REAL_V1(response.price || 0.0),
          description: response.description,
          createdAt: FORMATTED_DATE(`${response.createdAt}`)
        });
      } catch (error) {
        console.log(JSON.parse(JSON.stringify(error)));
      }
    })();
  }, [productId]);

  return (
    <>
      <Header
        title='Página Produtos'
        subTitle='Aqui voçê irá gerenciar seus Produtos!'
      />
      <div className='w-full flex items-center py-4 '>
        <Link
          className='bg-gray-500 p-1 rounded-sm text-white'
          href='/dashboard/products'
        >
          <ChevronLeft />
        </Link>
      </div>

      <div className='mt-7'>
        <h1>Atualizar de Produto</h1>
        <div className='flex flex-col gap-2 mt-7'>
          <div className='flex gap-2'>
            <InputRoot className='w-full'>
              <InputLabel>Código: *</InputLabel>
              <InputDefault
                className='bg-gray-400 font-semibold'
                disabled
                type='text'
                value={fields.sku}
              />
            </InputRoot>
            <InputRoot className='w-full'>
              <InputLabel>Data cadastro: *</InputLabel>
              <InputDefault
                className='bg-gray-400 font-semibold'
                disabled
                type='text'
                value={fields.createdAt}
              />
            </InputRoot>
          </div>
          <div className='flex flex-col gap-2 lg:flex-row'>
            <InputRoot className='w-full'>
              <InputLabel>COD: *</InputLabel>
              <InputDefault
                name={'sku'}
                className='placeholder:text-gray-700'
                placeholder={'sku'}
                type='text'
                value={fields.sku}
                onChange={handleChange}
                maxLength={36}
              />
            </InputRoot>
            <InputRoot className='w-full'>
              <InputLabel>Preço: *</InputLabel>
              <InputDefault
                name='price'
                className='placeholder:text-gray-700'
                type='text'
                value={fields.price}
                onChange={handleChange}
              />
            </InputRoot>
          </div>
          <InputRoot>
            <InputLabel>Nome: *</InputLabel>
            <InputDefault
              className='placeholder:text-gray-700'
              placeholder={fields.name}
              name='name'
              type='text'
              value={fields.name}
              onChange={handleChange}
            />
          </InputRoot>

          <InputRoot>
            <InputLabel>Descrição: *</InputLabel>
            <InputTextArea
              cols={10}
              rows={6}
              name='description'
              placeholder={fields.description}
              className='resize-none placeholder:text-gray-700'
              value={fields.description}
              onChange={handleChange}
            />
          </InputRoot>
          <ButtonRoot
            onClick={handleSubmit}
            className='bg-white hover:bg-black'
          >
            <ButtonText className='text-black group-hover:text-white'>
              Atualizar
            </ButtonText>
          </ButtonRoot>
        </div>
      </div>
    </>
  );
}
