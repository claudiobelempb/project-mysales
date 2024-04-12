'use client';

import { ButtonRoot, ButtonText } from '@/components/ButtonRoot';
import { Header } from '@/components/header';
import {
  InputDefault,
  InputLabel,
  InputRoot,
  InputTextArea
} from '@/components/InputRoot';
import { ProductResponse } from '@/http/response/ProductResponse';
import { ProductFindByIdService } from '@/services/product/ProductFindByIdService';
import { ProductUpdateService } from '@/services/product/ProductUpdateService';
import { dateFormatted } from '@/utils/format/date';
import { formatBigDecimal } from '@/utils/format/money';
import { limitWords } from '@/utils/Helpers';
import { maskReal } from '@/utils/mask/money';
import { ChevronLeft } from 'lucide-react';
import Link from 'next/link';

import { ChangeEvent, FormEvent, useEffect, useState } from 'react';
import { toast } from 'react-toastify';

type ParamsProps = {
  id: string;
};
type ProductsProps = {
  params: ParamsProps;
};

type fieldsProps = {
  id: number;
  sku: string;
  name: string;
  price: number | string;
  description: string;
};

export default function Products({ params }: ProductsProps) {
  const [fields, setFields] = useState<ProductResponse>({} as ProductResponse);

  const productId = params.id;
  console.log(
    'Email => ',
    limitWords('claudio c lima @hotmail com', 10, '...')
  );

  const handleSubmit = async (event: FormEvent) => {
    event.preventDefault();
    try {
      const product: fieldsProps = {
        id: parseFloat(productId),
        sku: fields.sku,
        price: formatBigDecimal(`${fields.price}`),
        name: fields.name,
        description: fields.description
      };

      const response = await ProductUpdateService(product);
      setFields({
        ...response,
        createdAt: dateFormatted(`${response.createdAt}`)
      });
      toast.success('Produto atualizado com sucesso!');
    } catch (error) {
      console.log('Error =>', error);
    }
  };

  function handleChange(
    event: ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) {
    const { name, value } = event.target;
    const field = { ...fields, [name]: value };

    setFields({ ...field, price: maskReal(`${field.price}`) });
  }

  useEffect(() => {
    (async function loadingProduct() {
      try {
        const response = await ProductFindByIdService(productId);
        setFields({
          ...response,
          createdAt: dateFormatted(`${response.createdAt}`)
        });
      } catch (error) {
        console.log(error);
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
                value={fields.id}
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
                placeholder={`${fields.price ? fields.price : 0.0}`}
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
